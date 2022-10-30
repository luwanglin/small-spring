package cn.luwanglin.springframework.beans.factory.xml;

import cn.hutool.core.util.StrUtil;
import cn.luwanglin.springframework.beans.BeansException;
import cn.luwanglin.springframework.beans.PropertyValue;
import cn.luwanglin.springframework.beans.factory.config.BeanDefinition;
import cn.luwanglin.springframework.beans.factory.config.BeanReference;
import cn.luwanglin.springframework.beans.factory.support.AbstractBeanDefinitionReader;
import cn.luwanglin.springframework.beans.factory.support.BeanDefinitionRegistry;
import cn.luwanglin.springframework.context.annotation.ClassPathBeanDefinitionScanner;
import cn.luwanglin.springframework.core.io.Resource;
import cn.luwanglin.springframework.core.io.ResourceLoader;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @author: luwanglin
 * @email: luwanglin@meituan.com
 * @date: 2022/9/17 20:00
 * @description:
 */
public class XmlBeanDefinitionReader extends AbstractBeanDefinitionReader {
    public XmlBeanDefinitionReader(BeanDefinitionRegistry registry) {
        super(registry);
    }

    public XmlBeanDefinitionReader(BeanDefinitionRegistry registry, ResourceLoader resourceLoader) {
        super(registry, resourceLoader);
    }

    @Override
    public void loadBeanDefinitions(Resource resource) throws BeansException {
        try (InputStream is = resource.getInputStream()) {
            doLoadBeanDefinitions(is);
        } catch (IOException | ClassNotFoundException | DocumentException e) {
            throw new BeansException("IOException parsing XML document from " + resource, e);
        }
    }

    @Override
    public void loadBeanDefinitions(Resource... resources) throws BeansException {
        for (Resource resource : resources) {
            loadBeanDefinitions(resource);
        }
    }

    @Override
    public void loadBeanDefinitions(String location) throws BeansException {
        Resource resource = getResourceLoader().getResource(location);
        loadBeanDefinitions(resource);
    }

    @Override
    public void loadBeanDefinitions(String... locations) throws BeansException {
        for (String location : locations) {
            loadBeanDefinitions(location);
        }
    }

    public void doLoadBeanDefinitions(InputStream inputStream) throws ClassNotFoundException, DocumentException {
        SAXReader reader = new SAXReader();
        Document doc = reader.read(inputStream);
        Element root = doc.getRootElement();
        // 解析 context:component-scan 标签，扫描包中的类并提取相关信息，用于组装 BeanDefinition
        Element componentScan = root.element("component-scan");
        if (componentScan != null) {
            String scanPath = componentScan.attributeValue("base-package");
            if (StrUtil.isEmpty(scanPath)) {
                throw new BeansException("The value of base-package attribute can not be empty or null");
            }
            scanPackage(scanPath);
        }
        List<Element> beanList = root.elements("bean");

        for (Element bean : beanList) {
            String id = bean.attributeValue("id");
            String name = bean.attributeValue("name");
            String className = bean.attributeValue("class");

            // 增加对init-method、destroy-method的读取
            String initMethodName = bean.attributeValue("init-method");
            String destroyMethodName = bean.attributeValue("destroy-method");
            String beanScope = bean.attributeValue("scope");

            Class<?> clazz = Class.forName(className);
            // 优先级 id > name
            String beanName = StrUtil.isNotEmpty(id) ? id : name;
            if (StrUtil.isEmpty(beanName)) {
                beanName = StrUtil.lowerFirst(clazz.getSimpleName());
            }

            // 定义bean
            BeanDefinition beanDefinition = new BeanDefinition(clazz);
            // 设置inti 和destroy方法
            beanDefinition.setInitMethodName(initMethodName);
            beanDefinition.setDestroyMethodName(destroyMethodName);
            if (StrUtil.isNotEmpty(beanScope)) {
                beanDefinition.setScope(beanScope);
            }
            List<Element> properties = bean.elements("property");
            // 读取属性节点并填充
            for (Element property : properties) {
                // 解析标签
                String attrName = property.attributeValue("name");
                String attrValue = property.attributeValue("value");
                String attrRef = property.attributeValue("ref");

                // 获取属性值：引入对象 、值对象
                Object value = StrUtil.isNotEmpty(attrRef) ? new BeanReference(attrRef) : attrValue;
                PropertyValue propertyValue = new PropertyValue(attrName, value);
                beanDefinition.getPropertyValues().addPropertyValue(propertyValue);
            }
            if (getRegistry().containsBeanDefinition(beanName)) {
                throw new BeansException("Duplicate beanName[" + beanName + "] is not allowed");
            }
            // 注册beanDefinition
            getRegistry().registerBeanDefinition(beanName, beanDefinition);
        }
    }

    private void scanPackage(String scanPath) {
        String[] basePackage = StrUtil.splitToArray(scanPath, ',');
        ClassPathBeanDefinitionScanner classPathBeanDefinitionScanner = new ClassPathBeanDefinitionScanner(getRegistry());
        classPathBeanDefinitionScanner.doScan(basePackage);
    }
}

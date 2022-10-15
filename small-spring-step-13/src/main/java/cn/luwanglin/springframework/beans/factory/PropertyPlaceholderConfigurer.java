package cn.luwanglin.springframework.beans.factory;

import cn.luwanglin.springframework.beans.BeansException;
import cn.luwanglin.springframework.beans.PropertyValue;
import cn.luwanglin.springframework.beans.PropertyValues;
import cn.luwanglin.springframework.beans.factory.config.BeanDefinition;
import cn.luwanglin.springframework.beans.factory.config.BeanFactoryPostProcessor;
import cn.luwanglin.springframework.core.io.DefaultResourceLoader;
import cn.luwanglin.springframework.core.io.Resource;

import java.io.IOException;
import java.util.Properties;

/**
 * @author: luwanglin
 * @email: luwanglin@meituan.com
 * @date: 2022/10/7 17:24
 * @description:
 */
public class PropertyPlaceholderConfigurer implements BeanFactoryPostProcessor {
    /**
     * Default placeholder prefix: {@value}
     */
    private static final String DEFAULT_PLACEHOLDER_PREFIX = "${";

    /**
     * Default placeholder suffix: {@value}
     */
    private static final String DEFAULT_PLACEHOLDER_SUFFIX = "}";

    private String location;

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        // 加载属性文件
        try {
            DefaultResourceLoader resourceLoader = new DefaultResourceLoader();
            Resource resource = resourceLoader.getResource(location);
            Properties properties = new Properties();
            properties.load(resource.getInputStream());
            String[] beanDefinitionNames = beanFactory.getBeanDefinitionNames();
            for (String beanName : beanDefinitionNames) {
                BeanDefinition beanDefinition = beanFactory.getBeanDefinition(beanName);
                PropertyValues propertyValues = beanDefinition.getPropertyValues();
                for (PropertyValue propertyValue : propertyValues.getPropertyValues()) {
                    Object value = propertyValue.getValue();
                    if (!(value instanceof String)) {
                        // 如果是BeanReference就不用处理了
                        continue;
                    }
                    String val = (String) value;
                    StringBuilder stringBuilder = new StringBuilder(val);
                    int startIdx = val.indexOf(DEFAULT_PLACEHOLDER_PREFIX);
                    int stopIdx = val.indexOf(DEFAULT_PLACEHOLDER_SUFFIX);
                    if (startIdx != -1 && stopIdx != -1 && startIdx < stopIdx) {
                        String proKey = val.substring(startIdx + 2, stopIdx);
                        String proVal = properties.getProperty(proKey);
                        stringBuilder.replace(startIdx, stopIdx + 1, proVal);
                        // 这里存在一个问题：并没有对已有的property进行替换或者合并，但真正的Spring中是没有这个问题的
                        propertyValues.addPropertyValue(new PropertyValue(propertyValue.getName(), stringBuilder.toString()));
                    }
                }
            }
        } catch (IOException e) {
            throw new BeansException("Could not load properties", e);
        }
    }

    public void setLocation(String location) {
        this.location = location;
    }
}

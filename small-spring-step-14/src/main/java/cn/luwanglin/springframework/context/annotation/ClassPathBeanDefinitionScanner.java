package cn.luwanglin.springframework.context.annotation;

import cn.hutool.core.util.StrUtil;
import cn.luwanglin.springframework.beans.factory.annotation.AutowiredAnnotationBeanPostProcessor;
import cn.luwanglin.springframework.beans.factory.config.BeanDefinition;
import cn.luwanglin.springframework.beans.factory.support.BeanDefinitionRegistry;
import cn.luwanglin.springframework.stereotype.Component;

import java.util.Set;

/**
 * @author: luwanglin
 * @email: luwanglin@meituan.com
 * @date: 2022/10/7 18:53
 * @description:
 */
public class ClassPathBeanDefinitionScanner extends ClassPathScanningCandidateComponentProvider {
    private BeanDefinitionRegistry registry;

    public ClassPathBeanDefinitionScanner(BeanDefinitionRegistry registry) {
        this.registry = registry;
    }

    public void doScan(String... basePackages) {
        for (String basePackage : basePackages) {
            Set<BeanDefinition> candidates = findCandidateComponents(basePackage);
            for (BeanDefinition beanDefinition : candidates) {
                // 解析Bean的作用域singleton、prototype
                String beanScope = resolveBeanScope(beanDefinition);
                if (StrUtil.isNotEmpty(beanScope)) {
                    beanDefinition.setScope(beanScope);
                }
                registry.registerBeanDefinition(determineBeanName(beanDefinition), beanDefinition);
            }
        }
        // 注册处理注解的 BeanPostProcessor（@Autowired、@Value）
        registry.registerBeanDefinition("cn.luwanglin.springframework.context.annotation" +
                ".internalAutowiredAnnotationProcessor", new BeanDefinition(AutowiredAnnotationBeanPostProcessor.class));
    }

    private String resolveBeanScope(BeanDefinition beanDefinition) {
        Class beanClass = beanDefinition.getBeanClass();
        Scope scope = (Scope) beanClass.getAnnotation(Scope.class);
        if (scope != null) {
            return scope.value();
        }
        return StrUtil.EMPTY;
    }

    private String determineBeanName(BeanDefinition beanDefinition) {
        Class beanClass = beanDefinition.getBeanClass();
        // 在上面调用findCandidateComponents方法找到的都是带有Component注解的类，因此这里获取Component注解一定不为空
        Component component = (Component) beanClass.getAnnotation(Component.class);
        String value = component.value();
        if (StrUtil.isNotEmpty(value)) {
            return value;
        }
        return StrUtil.lowerFirst(beanClass.getSimpleName());
    }
}

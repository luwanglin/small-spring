package cn.bugstack.springframework.luwanglin.beans.factory.support;

import cn.bugstack.springframework.luwanglin.core.io.DefaultResourceLoader;
import cn.bugstack.springframework.luwanglin.core.io.ResourceLoader;

/**
 * @author: luwanglin
 * @email: luwanglin@meituan.com
 * @date: 2022/9/17 19:55
 * @description:
 */
public abstract class AbstractBeanDefinitionReader implements BeanDefinitionReader {
    private final BeanDefinitionRegistry registry;

    private final ResourceLoader resourceLoader;

    public AbstractBeanDefinitionReader(BeanDefinitionRegistry registry) {
        this.registry = registry;
        this.resourceLoader = new DefaultResourceLoader();
    }

    public AbstractBeanDefinitionReader(BeanDefinitionRegistry registry, ResourceLoader resourceLoader) {
        this.registry = registry;
        this.resourceLoader = resourceLoader;
    }

    @Override
    public BeanDefinitionRegistry getRegistry() {
        return registry;
    }

    @Override
    public ResourceLoader getResourceLoader() {
        return resourceLoader;
    }
}

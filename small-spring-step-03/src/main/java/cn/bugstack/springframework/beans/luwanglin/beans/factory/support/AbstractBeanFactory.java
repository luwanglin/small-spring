package cn.bugstack.springframework.beans.luwanglin.beans.factory.support;

import cn.bugstack.springframework.beans.luwanglin.BeansException;
import cn.bugstack.springframework.beans.luwanglin.beans.factory.BeanFactory;
import cn.bugstack.springframework.beans.luwanglin.beans.factory.config.BeanDefinition;

/**
 * @author: luwanglin
 * @email: luwanglin@meituan.com
 * @date: 2022/9/6 00:19
 * @description:
 */
public abstract class AbstractBeanFactory extends DefaultSingletonBeanFactory implements BeanFactory {
    @Override
    public Object getBean(String beanName) {
        return doGetBean(beanName, null);
    }

    @Override
    public Object getBean(String beanName, Object... args) {
        return doGetBean(beanName, args);
    }

    protected <T> T doGetBean(final String name, final Object[] args) {
        Object bean = getSingleton(name);
        if (bean != null) {
            return (T) bean;
        }

        BeanDefinition beanDefinition = getBeanDefinition(name);
        return (T) createBean(name, beanDefinition, args);
    }


    protected abstract Object createBean(String beanName, BeanDefinition beanDefinition, Object[] args) throws BeansException;

    protected abstract BeanDefinition getBeanDefinition(String beanName) throws BeansException;
}

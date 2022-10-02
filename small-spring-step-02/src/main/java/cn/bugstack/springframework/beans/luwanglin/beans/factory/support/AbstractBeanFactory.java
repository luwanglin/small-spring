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
        Object bean = getSingleton(beanName);
        if (null != bean) {
            return bean;
        }
        BeanDefinition beanDefinition = getBeanDefinition(beanName);
        return createBean(beanName, beanDefinition);
    }

    protected abstract Object createBean(String beanName, BeanDefinition beanDefinition) throws BeansException;

    protected abstract BeanDefinition getBeanDefinition(String beanName) throws BeansException;
}

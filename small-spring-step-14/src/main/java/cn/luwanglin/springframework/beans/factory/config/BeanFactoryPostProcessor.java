package cn.luwanglin.springframework.beans.factory.config;


import cn.luwanglin.springframework.beans.BeansException;
import cn.luwanglin.springframework.beans.factory.ConfigurableListableBeanFactory;

/**
 * @author: luwanglin
 * @email: luwanglin@meituan.com
 * @date: 2022/9/18 16:48
 * @description:
 */
public interface BeanFactoryPostProcessor {
    /**
     * 在所有的 BeanDefinition 加载完成后，实例化 Bean 对象之前，提供修改 BeanDefinition 属性的机制
     *
     * @param beanFactory
     * @throws BeansException
     */
    void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException;

}

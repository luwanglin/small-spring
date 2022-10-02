package cn.bugstack.springframework.luwanglin.beans.factory;

import cn.bugstack.springframework.luwanglin.beans.BeansException;
import cn.bugstack.springframework.luwanglin.beans.factory.config.AutowireCapableBeanFactory;
import cn.bugstack.springframework.luwanglin.beans.factory.config.BeanDefinition;
import cn.bugstack.springframework.luwanglin.beans.factory.config.BeanPostProcessor;
import cn.bugstack.springframework.luwanglin.beans.factory.config.ConfigurableBeanFactory;
import cn.bugstack.springframework.luwanglin.beans.factory.xml.ListableBeanFactory;

/**
 * @author: luwanglin
 * @email: luwanglin@meituan.com
 * @date: 2022/9/18 17:08
 * @description:
 */
public interface ConfigurableListableBeanFactory extends ListableBeanFactory, AutowireCapableBeanFactory, ConfigurableBeanFactory {
    BeanDefinition getBeanDefinition(String beanName) throws BeansException;

    void preInstantiateSingletons() throws BeansException;

    void addBeanPostProcessor(BeanPostProcessor beanPostProcessor);
}

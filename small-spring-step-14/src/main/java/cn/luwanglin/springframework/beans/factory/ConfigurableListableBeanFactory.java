package cn.luwanglin.springframework.beans.factory;

import cn.luwanglin.springframework.beans.BeansException;
import cn.luwanglin.springframework.beans.factory.config.AutowireCapableBeanFactory;
import cn.luwanglin.springframework.beans.factory.config.BeanDefinition;
import cn.luwanglin.springframework.beans.factory.config.BeanPostProcessor;
import cn.luwanglin.springframework.beans.factory.config.ConfigurableBeanFactory;
import cn.luwanglin.springframework.beans.factory.xml.ListableBeanFactory;

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

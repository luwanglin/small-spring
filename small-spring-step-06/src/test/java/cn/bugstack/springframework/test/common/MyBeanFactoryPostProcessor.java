package cn.bugstack.springframework.test.common;


import cn.bugstack.springframework.luwanglin.beans.BeansException;
import cn.bugstack.springframework.luwanglin.beans.PropertyValue;
import cn.bugstack.springframework.luwanglin.beans.PropertyValues;
import cn.bugstack.springframework.luwanglin.beans.factory.ConfigurableListableBeanFactory;
import cn.bugstack.springframework.luwanglin.beans.factory.config.BeanDefinition;
import cn.bugstack.springframework.luwanglin.beans.factory.config.BeanFactoryPostProcessor;

public class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor {

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {

        BeanDefinition beanDefinition = beanFactory.getBeanDefinition("userService");
        PropertyValues propertyValues = beanDefinition.getPropertyValues();

        propertyValues.addPropertyValue(new PropertyValue("company", "改为：字节跳动"));
    }

}

package cn.bugstack.springframework.beans.luwanglin.beans.factory.support;

import cn.bugstack.springframework.beans.luwanglin.beans.BeansException;
import cn.bugstack.springframework.beans.luwanglin.beans.factory.config.BeanDefinition;

import java.lang.reflect.Constructor;

/**
 * @author: luwanglin
 * @email: luwanglin@meituan.com
 * @date: 2022/9/9 00:48
 * @description:
 */
public interface InstantiationStrategy {

    Object instantiate(BeanDefinition beanDefinition, String beanName, Constructor ctor, Object[] args) throws BeansException;

}


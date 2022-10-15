package cn.luwanglin.springframework.beans.factory;

import cn.bugstack.springframework.beans.BeansException;

/**
 * @author: luwanglin
 * @email: luwanglin@meituan.com
 * @date: 2022/9/6 00:20
 * @description:
 */
public interface BeanFactory {
    Object getBean(String beanName);

    Object getBean(String beanName, Object... args);

    <T> T getBean(String name, Class<T> requiredType) throws BeansException;
}

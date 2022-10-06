package cn.luwanglin.springframework.beans.factory.support;

import cn.luwanglin.springframework.beans.BeansException;
import cn.luwanglin.springframework.core.io.Resource;
import cn.luwanglin.springframework.core.io.ResourceLoader;

/**
 * @author: luwanglin
 * @email: luwanglin@meituan.com
 * @date: 2022/9/17 19:03
 * @description:
 */
public interface BeanDefinitionReader {

    BeanDefinitionRegistry getRegistry();

    ResourceLoader getResourceLoader();

    void loadBeanDefinitions(Resource resource) throws BeansException;

    void loadBeanDefinitions(Resource... resources) throws BeansException;

    void loadBeanDefinitions(String location) throws BeansException;
    void loadBeanDefinitions(String... locations) throws BeansException;


}

package cn.luwanglin.springframework.beans.factory.xml;


import cn.luwanglin.springframework.beans.BeansException;
import cn.luwanglin.springframework.beans.factory.BeanFactory;

import java.util.Map;

/**
 * @author: luwanglin
 * @email: luwanglin@meituan.com
 * @date: 2022/9/18 16:55
 * @description:
 */
public interface ListableBeanFactory extends BeanFactory {
    /**
     * 按照类型返回 Bean 实例
     *
     * @param type
     * @param <T>
     * @return
     * @throws BeansException
     */
    <T> Map<String, T> getBeansOfType(Class<T> type) throws BeansException;

    /**
     * Return the names of all beans defined in this registry.
     * <p>
     * 返回注册表中所有的Bean名称
     */
    String[] getBeanDefinitionNames();
}

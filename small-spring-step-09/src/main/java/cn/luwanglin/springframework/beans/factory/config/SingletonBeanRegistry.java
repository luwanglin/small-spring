package cn.luwanglin.springframework.beans.factory.config;

/**
 * @author: luwanglin
 * @email: luwanglin@meituan.com
 * @date: 2022/9/6 00:11
 * @description:
 */
public interface SingletonBeanRegistry {
    /**
     * @param beanName
     * @return 获取单例对象
     */
    Object getSingleton(String beanName);
}

package cn.luwanglin.springframework.beans.factory;

/**
 * @author: luwanglin
 * @email: luwanglin@meituan.com
 * @date: 2022/10/2 18:13
 * @description:
 */
public interface FactoryBean<T> {
    T getObject() throws Exception;

    Class<?> getObjectType();

    boolean isSingleton();
}

package cn.luwanglin.springframework.beans.factory;

/**
 * @author: luwanglin
 * @email: luwanglin@meituan.com
 * @date: 2022/10/2 14:22
 * @description:
 */
public interface BeanClassLoaderAware extends Aware {

    void setBeanClassLoader(ClassLoader classLoader);
}

package cn.luwanglin.springframework.beans.factory;

/**
 * @author: luwanglin
 * @email: luwanglin@meituan.com
 * @date: 2022/10/2 14:23
 * @description:
 */
public interface BeanNameAware extends Aware {

    void setBeanName(String name);
}

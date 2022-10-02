package cn.bugstack.springframework.beans.luwanglin.beans.factory;

/**
 * @author: luwanglin
 * @email: luwanglin@meituan.com
 * @date: 2022/9/6 00:20
 * @description:
 */
public interface BeanFactory {
    Object getBean(String beanName);
}

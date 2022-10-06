package cn.luwanglin.springframework.beans.factory.support;

import cn.hutool.core.util.StrUtil;
import cn.luwanglin.springframework.beans.BeansException;
import cn.luwanglin.springframework.beans.factory.DisposableBean;
import cn.luwanglin.springframework.beans.factory.config.BeanDefinition;

import java.lang.reflect.Method;

/**
 * @author: luwanglin
 * @email: luwanglin@meituan.com
 * @date: 2022/9/24 19:29
 * @description:
 */
public class DisposableBeanAdapter implements DisposableBean {
    private final Object bean;
    private final String beanName;
    private String destroyMethodName;

    public DisposableBeanAdapter(Object bean, String beanName, BeanDefinition beanDefinition) {
        this.bean = bean;
        this.beanName = beanName;
        this.destroyMethodName = beanDefinition.getDestroyMethodName();
    }

    @Override
    public void destroy() throws Exception {
        // 1、当为DisposableBean接口实现时，那么直接调用方法
        if (bean instanceof DisposableBean) {
            ((DisposableBean) bean).destroy();
        }
        // 2、配置的destroy-method {判断是为了避免二次执行销毁}
        if (StrUtil.isNotEmpty(destroyMethodName) && !(bean instanceof DisposableBean && "destroy".equals(destroyMethodName))) {
            Method destroyMethod;
            try {
                destroyMethod = bean.getClass().getMethod(destroyMethodName);
            } catch (NoSuchMethodException e) {
                throw new BeansException("Couldn't find a destroy method named '" + destroyMethodName + "' on bean with name '" + beanName + "'");
            }
            destroyMethod.invoke(bean);
        }
    }
}

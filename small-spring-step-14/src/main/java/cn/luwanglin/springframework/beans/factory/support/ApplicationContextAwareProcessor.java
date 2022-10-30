package cn.luwanglin.springframework.beans.factory.support;

import cn.luwanglin.springframework.beans.BeansException;
import cn.luwanglin.springframework.beans.factory.config.BeanPostProcessor;
import cn.luwanglin.springframework.context.ApplicationContext;
import cn.luwanglin.springframework.context.ApplicationContextAware;

/**
 * @author: luwanglin
 * @email: luwanglin@meituan.com
 * @date: 2022/10/2 14:26
 * @description:
 */
public class ApplicationContextAwareProcessor implements BeanPostProcessor {
    private final ApplicationContext applicationContext;

    public ApplicationContextAwareProcessor(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if (bean instanceof ApplicationContextAware) {
            ((ApplicationContextAware) bean).setApplicationContext(applicationContext);
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }
}

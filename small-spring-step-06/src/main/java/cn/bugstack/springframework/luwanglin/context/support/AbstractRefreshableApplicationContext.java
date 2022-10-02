package cn.bugstack.springframework.luwanglin.context.support;

import cn.bugstack.springframework.luwanglin.beans.BeansException;
import cn.bugstack.springframework.luwanglin.beans.factory.BeanFactory;
import cn.bugstack.springframework.luwanglin.beans.factory.ConfigurableListableBeanFactory;
import cn.bugstack.springframework.luwanglin.beans.factory.support.DefaultListableBeanFactory;

/**
 * @author: luwanglin
 * @email: luwanglin@meituan.com
 * @date: 2022/9/18 17:40
 * @description:
 */
public abstract class AbstractRefreshableApplicationContext extends AbstractApplicationContext {
    private DefaultListableBeanFactory beanFactory;

    @Override
    protected void refreshBeanFactory() throws BeansException {
        DefaultListableBeanFactory beanFactory = createBeanFactory();
        loadBeanDefinitions(beanFactory);
        this.beanFactory = beanFactory;
    }

    protected abstract void loadBeanDefinitions(DefaultListableBeanFactory beanFactory);

    private DefaultListableBeanFactory createBeanFactory() {
        return new DefaultListableBeanFactory();
    }

    @Override
    protected ConfigurableListableBeanFactory getBeanFactory() {
        return beanFactory;
    }
}

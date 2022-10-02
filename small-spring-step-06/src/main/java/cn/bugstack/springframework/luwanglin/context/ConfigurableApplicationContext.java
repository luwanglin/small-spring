package cn.bugstack.springframework.luwanglin.context;

import cn.bugstack.springframework.luwanglin.beans.BeansException;

/**
 * @author: luwanglin
 * @email: luwanglin@meituan.com
 * @date: 2022/9/18 16:59
 * @description:
 */
public interface ConfigurableApplicationContext extends ApplicationContext {
    /**
     * 刷新容器
     *
     * @throws BeansException
     */
    void refresh() throws BeansException;
}

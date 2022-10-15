package cn.luwanglin.springframework.context.event;

import cn.luwanglin.springframework.beans.factory.BeanFactory;
import cn.luwanglin.springframework.context.ApplicationEvent;
import cn.luwanglin.springframework.context.ApplicationListener;

/**
 * @author: luwanglin
 * @email: luwanglin@meituan.com
 * @date: 2022/10/4 17:24
 * @description:
 */
public class SimpleApplicationEventMulticaster extends AbstractApplicationEventMulticaster {

    public SimpleApplicationEventMulticaster(BeanFactory beanFactory) {
        setBeanFactory(beanFactory);
    }

    @SuppressWarnings("unchecked")
    @Override
    public void multicastEvent(ApplicationEvent event) {
        for (ApplicationListener listener : getApplicationListeners(event)) {
            listener.onApplicationEvent(event);
        }
    }
}

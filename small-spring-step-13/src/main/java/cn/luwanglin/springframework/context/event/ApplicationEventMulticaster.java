package cn.luwanglin.springframework.context.event;

import cn.luwanglin.springframework.context.ApplicationEvent;
import cn.luwanglin.springframework.context.ApplicationListener;

/**
 * @author: luwanglin
 * @email: luwanglin@meituan.com
 * @date: 2022/10/4 16:40
 * @description:
 */
public interface ApplicationEventMulticaster {
    /**
     * Add a listener to be notified of all events.
     *
     * @param listener the listener to add
     */
    void addApplicationListener(ApplicationListener<?> listener);

    /**
     * Remove a listener from the notification list.
     *
     * @param listener the listener to remove
     */
    void removeApplicationListener(ApplicationListener<?> listener);

    /**
     * Multicast the given application event to appropriate listeners.
     *
     * @param event the event to multicast
     */
    void multicastEvent(ApplicationEvent event);
}

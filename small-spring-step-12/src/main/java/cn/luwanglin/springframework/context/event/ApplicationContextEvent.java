package cn.luwanglin.springframework.context.event;

import cn.luwanglin.springframework.context.ApplicationContext;
import cn.luwanglin.springframework.context.ApplicationEvent;

/**
 * @author: luwanglin
 * @email: luwanglin@meituan.com
 * @date: 2022/10/4 16:36
 * @description:
 */
public class ApplicationContextEvent extends ApplicationEvent {
    public ApplicationContextEvent(Object source) {
        super(source);
    }

    public final ApplicationContext getApplicationContext() {
        return (ApplicationContext) getSource();
    }
}

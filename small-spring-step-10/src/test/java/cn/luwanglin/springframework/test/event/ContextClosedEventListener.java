package cn.luwanglin.springframework.test.event;

import cn.luwanglin.springframework.context.ApplicationListener;
import cn.luwanglin.springframework.context.event.ContextClosedEvent;

public class ContextClosedEventListener implements ApplicationListener<ContextClosedEvent> {

    @Override
    public void onApplicationEvent(ContextClosedEvent event) {
        System.out.println("关闭事件：" + this.getClass().getName());
    }

}

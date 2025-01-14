package cn.luwanglin.springframework.test.event;

import cn.luwanglin.springframework.context.ApplicationListener;

import java.util.Date;

/**
 * @author: luwanglin
 * @email: luwanglin@meituan.com
 * @date: 2022/10/4 18:12
 * @description:
 */
public class CustomEventListener implements ApplicationListener<CustomEvent> {
    @Override
    public void onApplicationEvent(CustomEvent event) {
        System.out.println("收到：" + event.getSource() + "消息;时间：" + new Date());
        System.out.println("消息：" + event.getId() + ":" + event.getMessage());
    }
}

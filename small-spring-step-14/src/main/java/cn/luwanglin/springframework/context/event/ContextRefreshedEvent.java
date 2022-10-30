package cn.luwanglin.springframework.context.event;

/**
 * @author: luwanglin
 * @email: luwanglin@meituan.com
 * @date: 2022/10/4 16:38
 * @description:
 */
public class ContextRefreshedEvent extends ApplicationContextEvent{
    public ContextRefreshedEvent(Object source) {
        super(source);
    }
}

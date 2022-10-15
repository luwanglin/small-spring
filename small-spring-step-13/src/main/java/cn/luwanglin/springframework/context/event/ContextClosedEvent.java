package cn.luwanglin.springframework.context.event;

/**
 * @author: luwanglin
 * @email: luwanglin@meituan.com
 * @date: 2022/10/4 16:38
 * @description:
 */
public class ContextClosedEvent extends ApplicationContextEvent {
    /**
     * Constructs a prototypical Event.
     *
     * @param source The object on which the Event initially occurred.
     * @throws IllegalArgumentException if source is null.
     */
    public ContextClosedEvent(Object source) {
        super(source);
    }
}

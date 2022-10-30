package cn.luwanglin.springframework.context;

import java.util.EventObject;

/**
 * @author: luwanglin
 * @email: luwanglin@meituan.com
 * @date: 2022/10/4 16:28
 * @description:
 */
public abstract class ApplicationEvent extends EventObject {

    public ApplicationEvent(Object source) {
        super(source);
    }
}

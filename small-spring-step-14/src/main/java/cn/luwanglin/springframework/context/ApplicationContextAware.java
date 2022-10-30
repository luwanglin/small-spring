package cn.luwanglin.springframework.context;

import cn.luwanglin.springframework.beans.BeansException;
import cn.luwanglin.springframework.beans.factory.Aware;

/**
 * @author: luwanglin
 * @email: luwanglin@meituan.com
 * @date: 2022/10/2 14:24
 * @description:
 */
public interface ApplicationContextAware extends Aware {
    void setApplicationContext(ApplicationContext applicationContext) throws BeansException;
}

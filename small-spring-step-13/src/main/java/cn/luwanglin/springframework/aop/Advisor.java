package cn.luwanglin.springframework.aop;

import org.aopalliance.aop.Advice;

/**
 * @author: luwanglin
 * @email: luwanglin@meituan.com
 * @date: 2022/10/6 16:55
 * @description:
 */
public interface Advisor {
    Advice getAdvice();
}

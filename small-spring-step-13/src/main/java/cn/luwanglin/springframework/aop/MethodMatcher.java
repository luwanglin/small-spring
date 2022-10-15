package cn.luwanglin.springframework.aop;

import java.lang.reflect.Method;

/**
 * @author: luwanglin
 * @email: luwanglin@meituan.com
 * @date: 2022/10/5 12:32
 * @description:
 */
public interface MethodMatcher {
    /**
     * Perform static checking whether the given method matches. If this
     * @return whether or not this method matches statically
     */
    boolean matches(Method method, Class<?> targetClass);
}

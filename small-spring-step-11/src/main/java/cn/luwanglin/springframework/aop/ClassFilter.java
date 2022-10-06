package cn.luwanglin.springframework.aop;

/**
 * @author: luwanglin
 * @email: luwanglin@meituan.com
 * @date: 2022/10/5 12:35
 * @description:
 */
public interface ClassFilter {
    /**
     * Should the pointcut apply to the given interface or target class?
     * @param clazz the candidate target class
     * @return whether the advice should apply to the given target class
     */
    boolean matches(Class<?> clazz);
}

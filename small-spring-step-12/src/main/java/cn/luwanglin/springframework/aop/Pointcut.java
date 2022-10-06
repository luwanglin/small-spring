package cn.luwanglin.springframework.aop;


/**
 * @author: luwanglin
 * @email: luwanglin@meituan.com
 * @date: 2022/10/5 12:30
 * @description:
 */
public interface Pointcut {
    /**
     * Return the ClassFilter for this pointcut.
     * @return the ClassFilter (never <code>null</code>)
     */
    ClassFilter getClassFilter();

    MethodMatcher getMethodMatcher();
}

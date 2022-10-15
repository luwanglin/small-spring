package cn.luwanglin.springframework.aop;

/**
 * @author: luwanglin
 * @email: luwanglin@meituan.com
 * @date: 2022/10/6 17:20
 * @description:
 */
public interface PointcutAdvisor extends Advisor {
    /**
     * Get the Pointcut that drives this advisor.
     */
    Pointcut getPointCut();
}

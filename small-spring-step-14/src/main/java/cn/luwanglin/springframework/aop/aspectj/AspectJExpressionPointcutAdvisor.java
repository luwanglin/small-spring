package cn.luwanglin.springframework.aop.aspectj;

import cn.luwanglin.springframework.aop.Pointcut;
import cn.luwanglin.springframework.aop.PointcutAdvisor;
import org.aopalliance.aop.Advice;

/**
 * @author: luwanglin
 * @email: luwanglin@meituan.com
 * @date: 2022/10/6 17:23
 * @description:
 */
public class AspectJExpressionPointcutAdvisor implements PointcutAdvisor {

    /**
     * 切面
     */
    private AspectJExpressionPointcut pointcut;

    /**
     * 通知
     */
    private Advice advice;

    /**
     * 表达式
     */
    private String expression;

    @Override

    public Advice getAdvice() {
        return advice;
    }

    @Override
    public Pointcut getPointCut() {
        if (pointcut == null) {
            return new AspectJExpressionPointcut(expression);
        }
        return pointcut;
    }

    public void setAdvice(Advice advice) {
        this.advice = advice;
    }

    public void setExpression(String expression) {
        this.expression = expression;
    }
}

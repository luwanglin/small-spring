package cn.luwanglin.springframework.aop.framework;

import cn.luwanglin.springframework.aop.AdvisedSupport;
import org.aopalliance.intercept.MethodInterceptor;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author: luwanglin
 * @email: luwanglin@meituan.com
 * @date: 2022/10/5 14:45
 * @description:
 */
public class JdkDynamicAopProxy implements AopProxy, InvocationHandler {
    private final AdvisedSupport advisedSupport;

    public JdkDynamicAopProxy(AdvisedSupport advisedSupport) {
        this.advisedSupport = advisedSupport;

    }

    @Override
    public Object getProxy() {
        return Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(),
                advisedSupport.getTargetSource().getTargetClass(), this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if (advisedSupport.getMethodMatcher().matches(method, advisedSupport.getTargetSource().getClass())) {
            MethodInterceptor interceptor = advisedSupport.getMethodInterceptor();
            return interceptor.invoke(new ReflectiveMethodInvocation(advisedSupport.getTargetSource().getTarget(),
                    method, args));
        }
        return method.invoke(advisedSupport.getTargetSource().getTarget(), args);
    }
}

package cn.luwanglin.springframework.test.bean;

import cn.luwanglin.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

/**
 * @author: luwanglin
 * @email: luwanglin@meituan.com
 * @date: 2022/10/6 18:21
 * @description:
 */
public class UserServiceBeforeAdvice implements MethodBeforeAdvice {
    @Override
    public void before(Method method, Object[] args, Object target) throws Throwable {
        System.out.println("拦截方法：" + method.getName());
    }
}

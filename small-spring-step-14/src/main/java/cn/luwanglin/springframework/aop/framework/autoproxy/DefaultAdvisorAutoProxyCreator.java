package cn.luwanglin.springframework.aop.framework.autoproxy;

import cn.luwanglin.springframework.aop.*;
import cn.luwanglin.springframework.aop.aspectj.AspectJExpressionPointcutAdvisor;
import cn.luwanglin.springframework.aop.framework.ProxyFactory;
import cn.luwanglin.springframework.beans.BeansException;
import cn.luwanglin.springframework.beans.PropertyValues;
import cn.luwanglin.springframework.beans.factory.BeanFactory;
import cn.luwanglin.springframework.beans.factory.BeanFactoryAware;
import cn.luwanglin.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor;
import cn.luwanglin.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.aopalliance.aop.Advice;
import org.aopalliance.intercept.MethodInterceptor;

import java.lang.reflect.InvocationTargetException;
import java.util.Collection;

/**
 * @author: luwanglin
 * @email: luwanglin@meituan.com
 * @date: 2022/10/6 17:46
 * @description:
 */
public class DefaultAdvisorAutoProxyCreator implements InstantiationAwareBeanPostProcessor, BeanFactoryAware {
    private DefaultListableBeanFactory beanFactory;

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        this.beanFactory = (DefaultListableBeanFactory) beanFactory;
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }

    @Override
    public Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) throws cn.bugstack.springframework.beans.BeansException {
        if (isInfrastructureClass(beanClass)) {
            // 注意这里的判断，如果是Advice、Advisor或者PointCut类型的子类，（比如DefaultAdvisorAutoProxyCreator），就不能增强拦截，
            // 否则会陷入死循环导致栈溢出
            // 会出现在AspectJExpressionPointcutAdvisor这个bean的创建过程中，
            // 因为postProcessBeforeInstantiation这个方法在createBean之前调用，然后下面的代码会
            // 查找AspectJExpressionPointcutAdvisor类型的Bean，查找不到时会去创建Bean，而创建Bean的话又会走到本方法中，这样就形成了一个
            // 死循环，最终导致栈溢出
            return null;
        }
        Collection<AspectJExpressionPointcutAdvisor> advisors =
                beanFactory.getBeansOfType(AspectJExpressionPointcutAdvisor.class).values();
        for (AspectJExpressionPointcutAdvisor advisor : advisors) {
            ClassFilter classFilter = advisor.getPointCut().getClassFilter();
            if (!classFilter.matches(beanClass)) {
                continue;
            }
            AdvisedSupport advisedSupport = new AdvisedSupport();
            TargetSource targetSource = null;
            try {
                targetSource = new TargetSource(beanClass.getDeclaredConstructor().newInstance());
            } catch (InstantiationException | IllegalAccessException | InvocationTargetException |
                     NoSuchMethodException e) {
                e.printStackTrace();
            }
            advisedSupport.setTargetSource(targetSource);
            advisedSupport.setMethodMatcher(advisor.getPointCut().getMethodMatcher());
            advisedSupport.setMethodInterceptor((MethodInterceptor) advisor.getAdvice());
            advisedSupport.setProxyTargetClass(false);
            return new ProxyFactory(advisedSupport).getProxy();
        }
        return null;
    }

    @Override
    public PropertyValues postProcessPropertyValues(PropertyValues pvs, Object bean, String beanName) throws BeansException {
        return pvs;
    }

    private boolean isInfrastructureClass(Class<?> beanClass) {
        return Advice.class.isAssignableFrom(beanClass) || Pointcut.class.isAssignableFrom(beanClass) || Advisor.class.isAssignableFrom(beanClass);
    }
}

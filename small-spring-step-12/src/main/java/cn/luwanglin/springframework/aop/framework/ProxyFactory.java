package cn.luwanglin.springframework.aop.framework;

import cn.luwanglin.springframework.aop.AdvisedSupport;

/**
 * @author: luwanglin
 * @email: luwanglin@meituan.com
 * @date: 2022/10/6 17:41
 * @description:
 */
public class ProxyFactory {
    private AdvisedSupport advisedSupport;

    public ProxyFactory(AdvisedSupport advisedSupport) {
        this.advisedSupport = advisedSupport;
    }

    public Object getProxy() {
        return createProxy().getProxy();
    }

    private AopProxy createProxy() {
        if (advisedSupport.isProxyTargetClass()) {
            return new Cglib2AopProxy(advisedSupport);
        }
        return new JdkDynamicAopProxy(advisedSupport);
    }
}

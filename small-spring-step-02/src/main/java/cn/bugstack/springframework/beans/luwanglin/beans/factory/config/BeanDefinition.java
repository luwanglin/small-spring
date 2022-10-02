package cn.bugstack.springframework.beans.luwanglin.beans.factory.config;

/**
 * @author: luwanglin
 * @email: luwanglin@meituan.com
 * @date: 2022/9/6 00:08
 * @description:
 */
public class BeanDefinition {
    private Class beanClass;

    public BeanDefinition(Class beanClass) {
        this.beanClass = beanClass;
    }

    public Class getBeanClass() {
        return beanClass;
    }

    public void setBeanClass(Class beanClass) {
        this.beanClass = beanClass;
    }
}

package cn.luwanglin.springframework.beans.factory.config;

/**
 * @author: luwanglin
 * @email: luwanglin@meituan.com
 * @date: 2022/9/11 14:08
 * @description:
 */
public class BeanReference {
    private final String beanName;

    public BeanReference(String beanName) {
        this.beanName = beanName;
    }

    public String getBeanName() {
        return beanName;
    }
}

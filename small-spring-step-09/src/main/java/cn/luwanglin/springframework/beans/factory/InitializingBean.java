package cn.luwanglin.springframework.beans.factory;

/**
 * @author: luwanglin
 * @email: luwanglin@meituan.com
 * @date: 2022/9/24 18:16
 * @description:
 */
public interface InitializingBean {

    /**
     * Bean 执行了属性填充后调用
     *
     * @throws Exception
     */
    void afterPropertiesSet() throws Exception;
}

package cn.luwanglin.springframework.beans.factory;

/**
 * @author: luwanglin
 * @email: luwanglin@meituan.com
 * @date: 2022/9/24 18:18
 * @description:
 */
public interface DisposableBean {
    void destroy() throws Exception;
}

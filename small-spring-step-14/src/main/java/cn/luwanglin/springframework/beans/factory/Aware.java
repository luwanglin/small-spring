package cn.luwanglin.springframework.beans.factory;

/**
 * * Marker superinterface indicating that a bean is eligible to be
 * * notified by the Spring container of a particular framework object
 * * through a callback-style method.  Actual method signature is
 * * determined by individual subinterfaces, but should typically
 * * consist of just one void-returning method that accepts a single
 * * argument.
 * *
 * *
 * *
 * *
 *
 * @author: luwanglin
 * @email: luwanglin@meituan.com
 * @date: 2022/10/2 14:19
 * @description: 标记类接口，实现该接口可以被Spring容器感知
 */
public interface Aware {

}

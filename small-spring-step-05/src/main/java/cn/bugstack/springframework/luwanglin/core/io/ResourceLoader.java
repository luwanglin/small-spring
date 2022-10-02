package cn.bugstack.springframework.luwanglin.core.io;

/**
 * @author: luwanglin
 * @email: luwanglin@meituan.com
 * @date: 2022/9/17 18:55
 * @description:
 */
public interface ResourceLoader {
    String CLASSPATH_URL_PREFIX = "classpath:";

    Resource getResource(String location);
}

package cn.luwanglin.springframework.core.io;

import cn.hutool.core.lang.Assert;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * @author: luwanglin
 * @email: luwanglin@meituan.com
 * @date: 2022/9/17 18:57
 * @description:
 */
public class DefaultResourceLoader implements ResourceLoader {
    @Override
    public Resource getResource(String location) {
        Assert.notNull(location, "Location must not be null");
        if (location.startsWith(CLASSPATH_URL_PREFIX)) {
            return new ClassPathResource(location.substring(CLASSPATH_URL_PREFIX.length()));
        } else {
            try {
                return new UrlResource(new URL(location));
            } catch (MalformedURLException e) {
                return new FileSystemResource(location);
            }
        }
    }
}

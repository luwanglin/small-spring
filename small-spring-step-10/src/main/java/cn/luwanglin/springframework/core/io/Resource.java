package cn.luwanglin.springframework.core.io;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author: luwanglin
 * @email: luwanglin@meituan.com
 * @date: 2022/9/17 18:39
 * @description:
 */
public interface Resource {
    InputStream getInputStream() throws IOException;
}

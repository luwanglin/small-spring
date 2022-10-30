package cn.luwanglin.springframework.stereotype;

import java.lang.annotation.*;

/**
 * @author: luwanglin
 * @email: luwanglin@meituan.com
 * @date: 2022/10/7 18:46
 * @description:
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Component {
    String value() default "";
}

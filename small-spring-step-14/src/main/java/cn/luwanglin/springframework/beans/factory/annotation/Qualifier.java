package cn.luwanglin.springframework.beans.factory.annotation;

import java.lang.annotation.*;

/**
 * @author: luwanglin
 * @email: luwanglin@meituan.com
 * @date: 2022/10/30 14:19
 * @description:
 */
@Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.TYPE, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
public @interface Qualifier {
    String value() default "";
}

package cn.luwanglin.springframework.beans.factory.annotation;

import java.lang.annotation.*;

/**
 * @author: luwanglin
 * @email: luwanglin@meituan.com
 * @date: 2022/10/30 14:20
 * @description:
 */
@Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Value {
    /**
     * The actual value expression: e.g. "#{systemProperties.myProp}".
     */
    String value();
}

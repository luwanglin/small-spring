package cn.bugstack.springframework.luwanglin.beans;

/**
 * @author: luwanglin
 * @email: luwanglin@meituan.com
 * @date: 2022/9/11 13:46
 * @description:
 */
public class PropertyValue {
    private final String name;
    private final Object value;

    public PropertyValue(String name, Object value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public Object getValue() {
        return value;
    }
}

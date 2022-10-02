package cn.bugstack.springframework.beans.luwanglin.beans;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: luwanglin
 * @email: luwanglin@meituan.com
 * @date: 2022/9/11 13:50
 * @description:
 */
public class PropertyValues {
    private final List<PropertyValue> propertyValueList = new ArrayList<>();

    public void addPropertyValue(PropertyValue propertyValue) {
        this.propertyValueList.add(propertyValue);
    }

    public PropertyValue[] getPropertyValues() {
        return propertyValueList.toArray(new PropertyValue[0]);
    }

    public PropertyValue getPropertyValue(String propertyName) {
        for (PropertyValue propertyValue : propertyValueList) {
            if (propertyValue.getName().equalsIgnoreCase(propertyName)) {
                return propertyValue;
            }
        }
        return null;
    }
}

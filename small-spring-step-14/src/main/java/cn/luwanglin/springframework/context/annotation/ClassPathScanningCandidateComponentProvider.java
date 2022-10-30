package cn.luwanglin.springframework.context.annotation;

import cn.hutool.core.util.ClassUtil;
import cn.luwanglin.springframework.beans.factory.config.BeanDefinition;
import cn.luwanglin.springframework.stereotype.Component;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 * @author: luwanglin
 * @email: luwanglin@meituan.com
 * @date: 2022/10/7 18:48
 * @description:
 */
public class ClassPathScanningCandidateComponentProvider {
    public Set<BeanDefinition> findCandidateComponents(String basePackage) {
        Set<BeanDefinition> candidates = new LinkedHashSet<>();
        Set<Class<?>> classes = ClassUtil.scanPackageByAnnotation(basePackage, Component.class);
        for (Class<?> clazz : classes) {
            candidates.add(new BeanDefinition(clazz));
        }
        return candidates;
    }
}

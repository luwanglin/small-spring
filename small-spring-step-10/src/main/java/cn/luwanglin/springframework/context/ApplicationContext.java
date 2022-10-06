package cn.luwanglin.springframework.context;


import cn.luwanglin.springframework.beans.factory.HierarchicalBeanFactory;
import cn.luwanglin.springframework.beans.factory.xml.ListableBeanFactory;
import cn.luwanglin.springframework.core.io.ResourceLoader;

/**
 * @author: luwanglin
 * @email: luwanglin@meituan.com
 * @date: 2022/9/18 16:54
 * @description:
 */
public interface ApplicationContext extends ListableBeanFactory, HierarchicalBeanFactory, ResourceLoader, ApplicationEventPublisher {


}

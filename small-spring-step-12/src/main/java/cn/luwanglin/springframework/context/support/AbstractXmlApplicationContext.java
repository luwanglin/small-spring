package cn.luwanglin.springframework.context.support;

import cn.luwanglin.springframework.beans.factory.support.DefaultListableBeanFactory;
import cn.luwanglin.springframework.beans.factory.xml.XmlBeanDefinitionReader;

/**
 * @author: luwanglin
 * @email: luwanglin@meituan.com
 * @date: 2022/9/18 17:56
 * @description:
 */
public abstract class AbstractXmlApplicationContext extends AbstractRefreshableApplicationContext {
    @Override
    protected void loadBeanDefinitions(DefaultListableBeanFactory beanFactory) {
        XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(beanFactory, this);
        String[] configLocations = getConfigLocations();
        if (null != configLocations) {
            xmlBeanDefinitionReader.loadBeanDefinitions(configLocations);
        }
    }

    protected abstract String[] getConfigLocations();
}

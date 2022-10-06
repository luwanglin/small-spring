package cn.luwanglin.springframework.test;

import cn.luwanglin.springframework.context.support.ClassPathXmlApplicationContext;
import cn.luwanglin.springframework.test.bean.UserServiceLwl;
import org.junit.Test;
import org.openjdk.jol.info.ClassLayout;

/**
 * 博客：https://bugstack.cn - 沉淀、分享、成长，让自己和他人都能有所收获！
 * 公众号：bugstack虫洞栈
 * Create by 小傅哥(fustack)
 */
public class ApiTestLwl {

    @Test
    public void test_prototype() {
        // 1.初始化 BeanFactory
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring_lwl" +
                ".xml");
        applicationContext.registerShutdownHook();

        // 2. 获取Bean对象调用方法
        UserServiceLwl userService01 = applicationContext.getBean("userServiceLwl", UserServiceLwl.class);
        UserServiceLwl userService02 = applicationContext.getBean("userServiceLwl", UserServiceLwl.class);

        // 3. 配置 scope="prototype/singleton"
        System.out.println(userService01);
        System.out.println(userService02);

        // 4. 打印十六进制哈希
        System.out.println(userService01 + " 十六进制哈希：" + Integer.toHexString(userService01.hashCode()));
        System.out.println(ClassLayout.parseInstance(userService01).toPrintable());

    }


    @Test
    public void test_factory_bean() {
        // 1.初始化 BeanFactory
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring_lwl" +
                ".xml");
        applicationContext.registerShutdownHook();

        // 2. 调用代理方法
        UserServiceLwl userService = applicationContext.getBean("userServiceLwl", UserServiceLwl.class);
        System.out.println("测试结果：" + userService.queryUserInfo());
    }
}

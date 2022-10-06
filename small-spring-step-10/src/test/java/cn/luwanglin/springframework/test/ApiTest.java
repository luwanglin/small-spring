package cn.luwanglin.springframework.test;

import cn.luwanglin.springframework.context.support.ClassPathXmlApplicationContext;
import cn.luwanglin.springframework.test.event.CustomEvent;
import org.junit.Test;

public class ApiTest {

    @Test
    public void test_event() {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring_lwl" +
                ".xml");
        applicationContext.publishEvent(new CustomEvent(applicationContext, 1019129009086763L, "成功了！"));

        applicationContext.registerShutdownHook();
    }

}

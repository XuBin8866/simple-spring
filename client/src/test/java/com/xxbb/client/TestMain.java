package com.xxbb.client;

import com.xxbb.client.controller.DispatcherServlet;
import com.xxbb.sspring.aop.AspectWeaver;
import com.xxbb.sspring.core.BeanContainer;
import com.xxbb.sspring.inject.DependencyInject;
import junit.framework.TestCase;
import org.junit.jupiter.api.DisplayName;

/**
 * @author xxbb
 */
public class TestMain extends TestCase {
    @DisplayName("AOP测试")
    public void testAop() {
        BeanContainer beanContainer = BeanContainer.getInstance();
        beanContainer.loadBeans("com.xxbb.client");
        new AspectWeaver().doAOP();
        new DependencyInject().doIoC();
        DispatcherServlet dispatcherServlet= (DispatcherServlet) beanContainer.getBean(DispatcherServlet.class);
        dispatcherServlet.showSomething();
    }

}

package com.xxbbb.demo;

import com.xxbb.client.controller.MainPageController;
import com.xxbb.client.service.combine.impl.HeadLineShopCategoryCombineServiceImpl;
import com.xxbb.sspring.core.BeanContainer;
import com.xxbb.sspring.core.annotation.Controller;
import com.xxbb.sspring.inject.DependencyInject;
import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.jupiter.api.Order;

import javax.servlet.http.HttpServlet;

public class BeanContainerTest extends TestCase {
    private static BeanContainer beanContainer = BeanContainer.getInstance();
    private static DependencyInject dependencyInject = new DependencyInject();


    @Order(1)
    public void testLoadBean() {
        Assert.assertFalse(beanContainer.isLoaded());
        beanContainer.loadBeans("com.xxbb.client");
        Assert.assertEquals(8, beanContainer.size());
        Assert.assertTrue(beanContainer.isLoaded());
    }

    @Order(2)
    public void testGetBean() {
        MainPageController mainPageController = (MainPageController) beanContainer.getBean(MainPageController.class);
        assertTrue(mainPageController instanceof MainPageController);
    }

    @Order(3)
    public void testAnnotation() {
        assertEquals(3, beanContainer.getClassesByAnnotation(Controller.class).size());
    }

    public void testSuper() {
        assertTrue(beanContainer.getClassesBySuper(HttpServlet.class).contains(MainPageController.class));
    }

    @Order(4)
    public void testIoc() {
        System.out.println(beanContainer.getBeans());
        dependencyInject.doIoC();
        Object obj = beanContainer.getBean(HeadLineShopCategoryCombineServiceImpl.class);
        System.out.println(obj);
    }
}
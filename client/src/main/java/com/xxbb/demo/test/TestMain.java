package com.xxbb.demo.test;

import com.xxbb.client.controller.DispatcherServlet;
import com.xxbb.demo.annotation.AnnotationService;
import com.xxbb.sspring.aop.AspectWeaver;
import com.xxbb.sspring.core.BeanContainer;
import com.xxbb.sspring.inject.DependencyInject;
import com.xxbb.sspring.util.ClassUtil;
import java.util.Set;


/**
 * @author xxbb
 */

public class TestMain{
    public static void main(String[] args) {
        AopTest();
    }
    public static void annotationTest(){
        AnnotationService annotationService=new AnnotationService();
        annotationService.annotationTest();
    }
    public static void loadTest(){
        Set<Class<?>> classes = ClassUtil.extractPackageClass("com.xxbb.client");
        System.out.println(classes);
    }
    public static void AopTest(){
        BeanContainer beanContainer = BeanContainer.getInstance();
        beanContainer.loadBeans("com.xxbb.client");
        new AspectWeaver().doAOP();
        new DependencyInject().doIoC();
        DispatcherServlet dispatcherServlet= (DispatcherServlet) beanContainer.getBean(DispatcherServlet.class);
        dispatcherServlet.showSomething();
    }
}

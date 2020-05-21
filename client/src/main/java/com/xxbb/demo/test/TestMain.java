package com.xxbb.demo.test;

import com.xxbb.demo.annotation.AnnotationService;
import com.xxbb.simpleframework.util.ClassUtil;

import java.util.Set;


/**
 * @author xxbb
 */

public class TestMain {
    public static void main(String[] args) {
        loadTest();
    }
    public static void annotationTest(){
        AnnotationService annotationService=new AnnotationService();
        annotationService.annotationTest();
    }
    public static void loadTest(){
        Set<Class<?>> classes = ClassUtil.extractPackageClass("com.xxbb.client");
        System.out.println(classes);
    }
}

package com.xxbb.demo.test;

import com.xxbb.demo.annotation.AnnotationService;


/**
 * @author xxbb
 */

public class TestMain {
    public static void main(String[] args) {
        annotationTest();
    }
    public static void annotationTest(){
        AnnotationService annotationService=new AnnotationService();
        annotationService.annotationTest();
    }
}

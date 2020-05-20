package com.xxbb.demo.annotation;

import com.xxbb.client.entity.po.HeadLine;

/**
 * @author xxbb
 */
public class AnnotationService {
    @TestAnnotation
    public void annotationTest(){
        System.out.println("测试注解");
    }
}

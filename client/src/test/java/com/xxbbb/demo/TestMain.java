package com.xxbbb.demo;

import com.xxbb.demo.annotation.AnnotationService;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author xxbb
 */

public class TestMain {
    @Test
    public void logTest(){
        Logger log= LoggerFactory.getLogger(this.getClass());
        log.debug("xxb");
    }
    @Test
    public void ObjectTest(){
        Object obj1=1;
        Object obj2="1";
        System.out.println(obj1.getClass());
        System.out.println(obj2.getClass());
    }
    @Test
    public void annotationTest(){
        AnnotationService annotationService=new AnnotationService();
        annotationService.annotationTest();
    }
    @Test
    public void frameworkTest(){

    }
}

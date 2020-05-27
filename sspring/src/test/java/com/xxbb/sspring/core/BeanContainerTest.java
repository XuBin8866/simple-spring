package com.xxbb.sspring.core;

import com.xxbb.sspring.util.LogUtil;
import junit.framework.TestCase;

public class BeanContainerTest extends TestCase {
    public void testLog(){
//        LogUtil.debug("LoggerUtil测试");
    }
    public void testClass(){
        Class<?> clazz= LogUtil.class;
        System.out.println(clazz.getSimpleName());
        System.out.println(clazz.getName());
    }
}
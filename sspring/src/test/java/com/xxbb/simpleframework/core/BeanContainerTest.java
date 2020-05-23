package com.xxbb.simpleframework.core;

import com.xxbb.simpleframework.util.LoggerUtil;
import junit.framework.TestCase;

public class BeanContainerTest extends TestCase {
    public void testLog(){
        LoggerUtil.LOGGER.debug("LoggerUtil测试");
    }
    public void testClass(){
        Class<?> clazz=LoggerUtil.class;
        System.out.println(clazz.getSimpleName());
        System.out.println(clazz.getName());
    }
}
package com.xxbb.client;

import com.xxbb.client.controller.DispatcherServlet;
import com.xxbb.client.controller.MainPageController;
import com.xxbb.sspring.aop.AspectWeaver;
import com.xxbb.sspring.core.BeanContainer;
import com.xxbb.sspring.inject.DependencyInject;
import junit.framework.TestCase;
import org.junit.jupiter.api.DisplayName;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author xxbb
 */
public class TestMain extends TestCase {
    public void testReflectError() throws IllegalAccessException, InstantiationException, InvocationTargetException {
        Class<?> clazz= MainPageController.class;
        Method[] declaredMethods = clazz.getDeclaredMethods();
        for(Method method:declaredMethods){
            System.out.println(method);
            if(method.getName().equals("throwException")){
                method.invoke(clazz.newInstance());
            }
        }
    }


}

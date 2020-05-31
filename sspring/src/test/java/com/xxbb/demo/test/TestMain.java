package com.xxbb.demo.test;

import com.xxbb.sspring.mvc.DispatcherServlet;
import com.xxbb.sspring.util.ClassUtil;
import com.xxbb.sspring.util.LogUtil;
import org.junit.Test;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Method;
import java.net.URL;
import java.util.Arrays;

/**
 * @author xxbb
 */
public class TestMain {
    @Test
    public void methodTest(){
        Class<?> clazz= B.class;
        Method[] methods=clazz.getDeclaredMethods();
        Method[] methods1=clazz.getMethods();
        System.out.println(Arrays.toString(methods));
        System.out.println("_______________________________");
        System.out.println(Arrays.toString(methods1));
    }
    @Test
    public void classLoaderTest(){
        URL resource = ClassUtil.getClassLoader().getResource("");
        System.out.println(resource);
    }
    @Test
    public void replaceTest(){
        String str="a.b.c.d";
        System.out.println(str.replace(".","/"));
    }
    @Test
    public void foreachTest(){
//        File[] files=null;
//        for(File file:files){
//            System.out.println("sadas");
//        }

    }
    @Test
    public void testLog() throws InterruptedException {
        LogUtil.getLogger().debug("debug");
        LogUtil.getLogger().error("error");
        LogUtil.getLogger().warn("warn");
        new Thread(()->{
            System.out.println(LoggerFactory.getLogger(Thread.currentThread().getName()));
            System.out.println("thread0"+LogUtil.getLogger());
        }).start();
        System.out.println(LoggerFactory.getLogger(Thread.currentThread().getName()));
        System.out.println(LogUtil.getLogger());
    }

}

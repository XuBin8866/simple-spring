package com.xxbb.demo.test;

import com.xxbb.simpleframework.util.ClassUtil;
import org.junit.Test;

import java.io.File;
import java.net.URL;

/**
 * @author xxbb
 */
public class TestMain {
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

}

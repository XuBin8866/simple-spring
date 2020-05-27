package com.xxbb.simpleframework.aop;

import com.xxbb.simpleframework.aop.aspect.AspectInfo;
import com.xxbb.simpleframework.util.ValidationUtil;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import javax.swing.text.rtf.RTFEditorKit;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * 向被代理对象的方法中添加横切逻辑
 * @author xxbb
 */
public class AspectListExecutor implements MethodInterceptor {
    /**
     * 被代理类
     */
    private Class<?> targetClass;
    /**
     * 切面数组
     */
    private List<AspectInfo> sortedAspectInfoList;

    public AspectListExecutor(Class<?> targetClass, List<AspectInfo> aspectInfoList) {
        this.targetClass = targetClass;
        this.sortedAspectInfoList = sortAspectInfoList(aspectInfoList);
    }



    @Override
    public Object intercept(Object o, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        Object returnValue=null;
        if(ValidationUtil.isEmpty(sortedAspectInfoList)){
            return null;
        }
        //1.按照order的顺序升序执行完所有的Aspect的before方法
        invokeBeforeAdvices(method,args);

        try {
            //2.执行被代理类的方法
            returnValue=methodProxy.invokeSuper(o, args);
            //3.如果代理方法返回正常，则安装order的顺序降序执行完所有的Aspect的afterRunning方法
            returnValue=invokeAfterReturningAdvices(method,args,returnValue);
        }catch (Exception e){
            //4.如果代理方法返回异常，则安装order的顺序降序执行完所有的Aspect的afterThrowing方法
            invokeAfterThrowingAdvices(method,args,e);
        }finally{
            //最终通知
            invokeAfterAdvices(method,args);
        }



        return null;
    }

    /**
     * 代理方法执行完成后，降序执行所有Aspect的after方法
     * @param method  方法
     * @param args 方法参数
     * @throws Throwable 异常
     */
    private void invokeAfterAdvices(Method method, Object[] args) throws Throwable {
        for(int i=sortedAspectInfoList.size()-1;i>=0;i--){
            sortedAspectInfoList.get(i).getAspectObject().after(targetClass,method,args);
        }
    }

    /**
     * 如果代理方法返回异常，则安装order的顺序降序执行完所有的Aspect的afterThrowing方法
     * @param method 方法
     * @param args 方法参数
     * @param e 异常传入值
     */
    private void invokeAfterThrowingAdvices(Method method, Object[] args, Exception e) throws Throwable {
        for(int i=sortedAspectInfoList.size()-1;i>=0;i--){
            sortedAspectInfoList.get(i).getAspectObject().afterThrowing(targetClass,method,args,e);
        }
    }

    /**
     * 如果代理方法返回正常，则安装order的顺序降序执行完所有的Aspect的afterRunning方法
     * @param method 方法
     * @param args 方法参数
     * @param returnValue 传入返回值
     * @return 返回值
     */
    private Object invokeAfterReturningAdvices(Method method, Object[] args, Object returnValue) throws Throwable {
        // TODO 每一次的result都被刷新了
        Object result=null;
        for(int i=sortedAspectInfoList.size()-1;i>=0;i--){
            result=sortedAspectInfoList.get(i).getAspectObject().afterReturning(targetClass,method,args,returnValue);

        }
        return result;
    }

    /**
     * 按照order的顺序升序执行完所有的Aspect的before方法
     * @param method 方法
     * @param args 方法参数
     */
    private void invokeBeforeAdvices(Method method, Object[] args) throws Throwable {
        for(AspectInfo aspectInfo:sortedAspectInfoList){
            aspectInfo.getAspectObject().before(targetClass,method,args);
        }
    }

    private List<AspectInfo> sortAspectInfoList(List<AspectInfo> aspectInfoList) {
        aspectInfoList.sort((o1, o2) -> o1.getOrderIndex() - o2.getOrderIndex());
        return aspectInfoList;
    }

    public List<AspectInfo> getSortedAspectInfoList() {
        return sortedAspectInfoList;
    }
}

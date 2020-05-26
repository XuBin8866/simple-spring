package com.xxbb.simpleframework.aop.aspect;

import java.lang.reflect.Method;

/**
 * @author xxbb
 */
public abstract class DefaultAspect {
    /**
     * 事前拦截
     * @param targetClass 被代理的目标类
     * @param method 被代理的目标方法
     * @param args 被代理的目标方法对应的参数列表
     * @throws Throwable 异常
     */
    public void before(Class<?> targetClass, Method method, Object[] args) throws Throwable{

    }

    /**
     * 事后拦截
     * @param targetClass 被代理的目标类
     * @param method 被代理的目标方法
     * @param args 被代理的目标方法对应的参数列表
     * @param returnValue 返回值
     * @throws Throwable 异常
     */
    public Object afterReturning(Class<?> targetClass, Method method, Object[] args,Object returnValue) throws Throwable{
        return returnValue;
    }

    /**
     * 异常拦截
     * @param targetClass 被代理的目标类
     * @param method 被代理的目标方法
     * @param args 被代理的目标方法对应的参数列表
     * @param throwable 异常
     * @throws Throwable 抛出异常
     */
    public void afterThrowing(Class<?> targetClass,Method method,Object[] args,Throwable throwable) throws Throwable{

    }
}

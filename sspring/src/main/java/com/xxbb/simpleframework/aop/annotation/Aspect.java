package com.xxbb.simpleframework.aop.annotation;

import java.lang.annotation.*;

/**
 * @author xxbb
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Aspect {
    /**
     * 切入点表达式
     * @return 切入点表达式
     */
    String pointcut();
}

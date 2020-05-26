package com.xxbb.simpleframework.aop.annotation;

import java.lang.annotation.*;

/**
 * @author xxbb
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Aspect {
    /**
     * 需要被织入横切逻辑的注解标签
     */
    Class<? extends Annotation> value();
}

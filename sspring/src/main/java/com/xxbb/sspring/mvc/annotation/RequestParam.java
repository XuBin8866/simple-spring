package com.xxbb.sspring.mvc.annotation;

/**
 * 请求参数
 * @author xxbb
 */
public @interface RequestParam {
    /**
     * q请求参数
     * @return 参数值
     */
    String value() default "";

    /**
     * 请求参数是否必须
     * @return 是否必须
     */
    boolean required() default true;
}

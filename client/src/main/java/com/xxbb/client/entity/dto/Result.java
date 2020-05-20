package com.xxbb.client.entity.dto;

/**
 * @author xxbb
 */
public class Result<T> {
    /**
     * 状态码，200表示成功
     */
    private int code;
    /**
     * 本次请求结果的详情
     */
    private String msg;
    /**
     * 请求返回的数据
     */
    private T data;
}

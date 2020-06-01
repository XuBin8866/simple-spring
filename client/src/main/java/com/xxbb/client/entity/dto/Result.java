package com.xxbb.client.entity.dto;

import com.xxbb.sspring.core.annotation.Repository;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author xxbb
 */
@Repository
@Data
@AllArgsConstructor
@NoArgsConstructor
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

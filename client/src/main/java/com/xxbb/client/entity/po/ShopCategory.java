package com.xxbb.client.entity.po;

import lombok.Data;

import java.util.Date;

/**
 * @author xxbb
 */

@Data
public class ShopCategory {
    private Long shopCategoryId;
    private String shopCategoryName;
    private String shopCategoryDesc;
    private String shopCategoryImg;
    private Integer priority;
    private Date createTime;
    private Date lastEditTime;
    private ShopCategory parent;
}

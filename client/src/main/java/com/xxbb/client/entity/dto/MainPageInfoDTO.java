package com.xxbb.client.entity.dto;

import com.xxbb.client.entity.po.HeadLine;
import com.xxbb.client.entity.po.ShopCategory;
import lombok.Data;

import java.util.List;

/**
 * @author xxbb
 */
@Data
public class MainPageInfoDTO {
    private List<HeadLine> headLineList;
    private List<ShopCategory> shopCategoryList;
}

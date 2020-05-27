package com.xxbb.client.entity.dto;

import com.xxbb.client.entity.po.HeadLine;
import com.xxbb.client.entity.po.ShopCategory;
import com.xxbb.sspring.core.annotation.Repository;
import lombok.Data;

import java.util.List;

/**
 * @author xxbb
 */
@Data
@Repository
public class MainPageInfoDTO {
    private List<HeadLine> headLineList;
    private List<ShopCategory> shopCategoryList;
}

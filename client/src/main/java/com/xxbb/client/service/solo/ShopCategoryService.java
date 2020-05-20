package com.xxbb.client.service.solo;

import com.xxbb.client.entity.dto.Result;
import com.xxbb.client.entity.po.ShopCategory;

import java.util.List;

/**
 * @author xxbb
 */
public interface ShopCategoryService {
    Result<Boolean> addShopCategory(ShopCategory shopCategory);
    Result<Boolean> removeShopCategory(int shopCategoryId);
    Result<Boolean> modifyShopCategory(ShopCategory shopCategory);
    Result<ShopCategory> queryShopCategoryById(int shopCategoryId);
    Result<List<ShopCategory>> queryShopCategory(ShopCategory shopCategory, int pageIndex, int pageSize);
}

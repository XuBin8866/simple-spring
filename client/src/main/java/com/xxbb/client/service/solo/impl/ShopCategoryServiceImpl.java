package com.xxbb.client.service.solo.impl;

import com.xxbb.client.entity.dto.Result;
import com.xxbb.client.entity.po.ShopCategory;
import com.xxbb.client.service.solo.ShopCategoryService;
import com.xxbb.sspring.core.annotation.Service;

import java.util.List;

/**
 * @author xxbb
 */
@Service
public class ShopCategoryServiceImpl implements ShopCategoryService {
    @Override
    public Result<Boolean> addShopCategory(ShopCategory shopCategory) {
        return null;
    }

    @Override
    public Result<Boolean> removeShopCategory(int shopCategoryId) {
        return null;
    }

    @Override
    public Result<Boolean> modifyShopCategory(ShopCategory shopCategory) {
        return null;
    }

    @Override
    public Result<ShopCategory> queryShopCategoryById(int shopCategoryId) {
        return null;
    }

    @Override
    public Result<List<ShopCategory>> queryShopCategory(ShopCategory shopCategory, int pageIndex, int pageSize) {
        return null;
    }
}

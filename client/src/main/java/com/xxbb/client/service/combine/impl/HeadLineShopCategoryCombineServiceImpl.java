package com.xxbb.client.service.combine.impl;

import com.xxbb.client.entity.dto.MainPageInfoDTO;
import com.xxbb.client.entity.dto.Result;
import com.xxbb.client.entity.po.HeadLine;
import com.xxbb.client.entity.po.ShopCategory;
import com.xxbb.client.service.combine.HeadLineShopCategoryCombineService;
import com.xxbb.client.service.solo.HeadLineService;
import com.xxbb.client.service.solo.ShopCategoryService;

import java.util.List;

/**
 * @author xxbb
 */
public class HeadLineShopCategoryCombineServiceImpl implements HeadLineShopCategoryCombineService {
    private HeadLineService headLineService;
    private ShopCategoryService shopCategoryService;
    @Override
    public Result<MainPageInfoDTO> getMainPageInfo() {
        //获取头条列表
        HeadLine headLineCondition=new HeadLine();
        headLineCondition.setEnableStatus(1);
        Result<List<HeadLine>> headLineResult = headLineService.queryHeadLine(headLineCondition, 1, 4);
        //获取店铺类别列表
        ShopCategory shopCategoryCondition=new ShopCategory();
        Result<List<ShopCategory>> shopCategoryResult = shopCategoryService.queryShopCategory(shopCategoryCondition, 1, 100);
        //合并数据返回
        Result<MainPageInfoDTO> result = mergeMainPageInfo(headLineResult, shopCategoryResult);
        return result;
    }

    private Result<MainPageInfoDTO> mergeMainPageInfo(Result<List<HeadLine>> headLineResult, Result<List<ShopCategory>> ShopCategoryResult) {
        return null;
    }
}

package com.xxbb.client.service.combine;

import com.xxbb.client.entity.dto.MainPageInfoDTO;
import com.xxbb.client.entity.dto.Result;
import com.xxbb.client.entity.po.HeadLine;
import com.xxbb.client.entity.po.ShopCategory;

import java.util.List;

/**
 * @author xxbb
 */
public interface HeadLineShopCategoryCombineService {
    Result<MainPageInfoDTO> getMainPageInfo();
}

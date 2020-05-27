package com.xxbb.client.service.solo.impl;

import com.xxbb.client.entity.dto.Result;
import com.xxbb.client.entity.po.HeadLine;
import com.xxbb.client.service.solo.HeadLineService;
import com.xxbb.sspring.core.annotation.Service;

import java.util.List;

/**
 * @author xxbb
 */
@Service
public class HeadLineServiceImpl implements HeadLineService {
    @Override
    public Result<Boolean> addHeadLine(HeadLine headLine) {
        return null;
    }

    @Override
    public Result<Boolean> removeHeadLine(int headLineId) {
        return null;
    }

    @Override
    public Result<Boolean> modifyHeadLine(HeadLine headLine) {
        return null;
    }

    @Override
    public Result<HeadLine> queryHeadLineById(int headLineId) {
        return null;
    }

    @Override
    public Result<List<HeadLine>> queryHeadLine(HeadLine headLine, int pageIndex, int pageSize) {
        return null;
    }
}

package com.xxbb.client.service.solo;

import com.xxbb.client.entity.dto.Result;
import com.xxbb.client.entity.po.HeadLine;

import java.util.List;

/**
 * @author xxbb
 */
public interface HeadLineService {
    Result<Boolean> addHeadLine(HeadLine headLine);
    Result<Boolean> removeHeadLine(int headLineId);
    Result<Boolean> modifyHeadLine(HeadLine headLine);
    Result<HeadLine> queryHeadLineById(int headLineId);
    Result<List<HeadLine>> queryHeadLine(HeadLine headLine,int pageIndex,int pageSize);
}

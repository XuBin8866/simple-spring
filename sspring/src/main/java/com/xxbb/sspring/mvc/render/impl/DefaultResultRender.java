package com.xxbb.sspring.mvc.render.impl;

import com.xxbb.sspring.mvc.RequestProcessorChain;
import com.xxbb.sspring.mvc.render.ResultRender;

/**
 *  默认渲染器
 * @author xxbb
 */
public class DefaultResultRender implements ResultRender {
    @Override
    public void render(RequestProcessorChain requestProcessorChain){
        requestProcessorChain.getResp().setStatus(requestProcessorChain.getResponseCode());
    }
}

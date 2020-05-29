package com.xxbb.sspring.mvc.render;

import com.xxbb.sspring.mvc.RequestProcessorChain;
import com.xxbb.sspring.mvc.processor.RequestProcessor;

/**
 * 渲染请求结果
 * @author xxbb
 */
public interface ResultRender {
    /**
     * 执行渲染
     * @param requestProcessorChain
     * @throws Exception
     */
     void render(RequestProcessorChain requestProcessorChain) throws Exception;
}

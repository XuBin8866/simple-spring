package com.xxbb.sspring.mvc.processor.impl;

import com.xxbb.sspring.mvc.RequestProcessorChain;
import com.xxbb.sspring.mvc.processor.RequestProcessor;

import javax.servlet.http.HttpServlet;

/**
 * @author xxbb
 */
public class ControllerRequestProcessor implements RequestProcessor {
    @Override
    public boolean process(RequestProcessorChain requestProcessorChain) throws Exception {
        return false;
    }
}

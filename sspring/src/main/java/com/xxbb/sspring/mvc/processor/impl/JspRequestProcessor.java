package com.xxbb.sspring.mvc.processor.impl;

import com.xxbb.sspring.mvc.RequestProcessorChain;
import com.xxbb.sspring.mvc.processor.RequestProcessor;
import com.xxbb.sspring.util.LogUtil;
import sun.reflect.generics.tree.ReturnType;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;

/**
 * @author xxbb
 */
public class JspRequestProcessor implements RequestProcessor {
    /**
     * jsp请求的RequestDispatcher的名称
     */
    private static final String JSP_SERVLET="jsp";
    /**
     * jsp请求资源的前缀
     */
    private static final String JSP_RESOURCE_PREFIX="/temp/";
    /**
     * jsp的RequestDispatcher,处理jsp资源
     */
    private RequestDispatcher jspServlet;

    public JspRequestProcessor(ServletContext servletContext) {
        jspServlet=servletContext.getNamedDispatcher(JSP_SERVLET);
        if(null==jspServlet) {
            throw new RuntimeException("There is no jsp servlet");
        }
    }

    @Override
    public boolean process(RequestProcessorChain requestProcessorChain) throws Exception {
        String requestPath=requestProcessorChain.getRequestPath();
        if(isJspResource(requestPath)){
            LogUtil.getLogger().info("jsp request path: {}",requestPath);
            jspServlet.forward(requestProcessorChain.getReq(),requestProcessorChain.getResp());
            return false;
        }
        return true;
    }

    /**
     * 是否请求的是jsp资源
     */
    private boolean isJspResource(String url) {
        return url.startsWith(JSP_RESOURCE_PREFIX);
    }
}
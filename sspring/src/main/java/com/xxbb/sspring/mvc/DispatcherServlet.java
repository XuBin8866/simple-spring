package com.xxbb.sspring.mvc;

import com.xxbb.sspring.aop.AspectWeaver;
import com.xxbb.sspring.core.BeanContainer;
import com.xxbb.sspring.inject.DependencyInject;
import com.xxbb.sspring.mvc.processor.RequestProcessor;
import com.xxbb.sspring.mvc.processor.impl.ControllerRequestProcessor;
import com.xxbb.sspring.mvc.processor.impl.JspRequestProcessor;
import com.xxbb.sspring.mvc.processor.impl.PreRequestProcessor;
import com.xxbb.sspring.mvc.processor.impl.StaticResourceRequestProcessor;
import org.apache.taglibs.standard.tag.common.fmt.RequestEncodingSupport;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author xxbb
 */
@WebServlet("/*")
public class DispatcherServlet extends HttpServlet {
    List<RequestProcessor> PROCESSORS=new ArrayList<>();

    @Override
    public void init() throws ServletException {
        //初始化容器
        BeanContainer beanContainer = BeanContainer.getInstance();
        beanContainer.loadBeans("com.xxbb.client");
        new AspectWeaver().doAspectOrientedProgramming();
        new DependencyInject().doDependencyInject();
        //初始化请求处理器责任链
        PROCESSORS.add(new PreRequestProcessor());
        PROCESSORS.add(new StaticResourceRequestProcessor(getServletContext()));
        PROCESSORS.add(new JspRequestProcessor(getServletContext()));
        PROCESSORS.add(new ControllerRequestProcessor());
    }
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.创建责任链对象实例
        RequestProcessorChain requestProcessorChain = new RequestProcessorChain(PROCESSORS.iterator(), req, resp);
        //2.通过责任链模式来一次调用请求处理器对请求进行处理
        requestProcessorChain.doRequestProcessorChain();
        //3.对处理结果进行渲染
        requestProcessorChain.doRender();

    }

}

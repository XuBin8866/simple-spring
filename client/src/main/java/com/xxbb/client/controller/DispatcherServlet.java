package com.xxbb.client.controller;

import com.xxbb.sspring.core.annotation.Controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author xxbb
 */
@WebServlet("/")
@Controller
public class DispatcherServlet extends HttpServlet {
    public void showSomething(){
        System.out.println("this is DispatcherServlet");
    }
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("request path is:"+req.getServletPath());
        System.out.println("request method is:"+req.getMethod());
        if("/frontend/get_main_page_info".equals(req.getServletPath())&&
        "GET".equals(req.getMethod())){
            new MainPageController().getMainPageInfo(req,resp);
        }else if("/superadmin/add_head_line".equals(req.getServletPath())&&
        "POST".equals(req.getMethod())){
            new HeadLineOperationController().addHeadLine(req,resp);
        }

    }
}

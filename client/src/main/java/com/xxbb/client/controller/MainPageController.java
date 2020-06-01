package com.xxbb.client.controller;

import com.xxbb.client.entity.dto.Result;
import com.xxbb.client.entity.po.User;
import com.xxbb.sspring.core.annotation.Controller;
import com.xxbb.sspring.mvc.annotation.RequestMapping;
import com.xxbb.sspring.mvc.annotation.RequestParam;
import com.xxbb.sspring.mvc.annotation.ResponseBody;
import com.xxbb.sspring.mvc.type.ModelAndView;
import com.xxbb.sspring.mvc.type.RequestMethod;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author xxbb
 */
@Controller
@RequestMapping
public class MainPageController extends HttpServlet {
    public void getMainPageInfo(HttpServletRequest req, HttpServletResponse resp) {

    }
    @RequestMapping(value = "/show",method = RequestMethod.GET)
    @ResponseBody
    public Object showResultRender(@RequestParam("name") String name){
        System.out.println("show请求"+name);
        User user=new User(1,"XXBB");
        Result<User> result=new Result<>();
        result.setCode(200);
        result.setMsg("yes");
        result.setData(user);
        return result;

    }
    @RequestMapping(value = "/result",method = RequestMethod.GET)
    public ModelAndView showView(){
        System.out.println("showView请求");
        User user=new User(1,"XXBB");
        Result<User> result=new Result<>();
        result.setCode(200);
        result.setMsg("yes");
        result.setData(user);
        Map<String ,Object> resultMap=new HashMap<>();
        resultMap.put("user",result);
        ModelAndView mv=new ModelAndView();
        mv.setView("result.jsp").addViewData("user",result);
        return mv;

    }
    @RequestMapping(value = "/error_test")
    @ResponseBody
    public void throwException(){
        System.out.println("throwException");
        throw new RuntimeException("抛出异常测试");
    }
}

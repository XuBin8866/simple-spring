package com.xxbb.sspring.mvc.render.impl;

import com.xxbb.sspring.mvc.RequestProcessorChain;
import com.xxbb.sspring.mvc.render.ResultRender;
import com.xxbb.sspring.mvc.type.ModeAndView;
import com.xxbb.sspring.util.LogUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * 页面渲染器
 * @author xxbb
 */
public class ViewResultRender implements ResultRender {
    public static final String VIEW_PATH = "/";
    private ModeAndView modeAndView;

    /**
     * 对传入参数进行处理
     * @param object 参数
     */
    public ViewResultRender(Object object) {
        if(object instanceof ModeAndView){
            //1.如果入参类型是ModelAndView，则直接赋值给成员变量
            this.modeAndView= (ModeAndView) object;
        }else if( object instanceof String){
            //2.如果入参类型是String，则为视图，需要包装后才赋值给成员变量
            this.modeAndView=new ModeAndView().setView((String) object);
        }else{
            //3.针对其他情况，则直接抛出异常
            LogUtil.getLogger().error("illegal request result type");
            throw new RuntimeException("illegal request result type");
        }
    }
    /**
     * 将请求处理结果按照视图路径转发至对应视图进行展示
     * @param requestProcessorChain 请求处理器
     * @throws Exception 异常
     */
    @Override
    public void render(RequestProcessorChain requestProcessorChain) throws Exception {
        HttpServletRequest request=requestProcessorChain.getReq();
        HttpServletResponse response=requestProcessorChain.getResp();
        String path=modeAndView.getView();
        Map<String,Object> model=modeAndView.getModel();
        for(Map.Entry<String,Object> entry:model.entrySet()){
            request.setAttribute(entry.getKey(),entry.getValue());
        }
        //跳转到jsp页面
        request.getRequestDispatcher(VIEW_PATH+path).forward(request,response);
    }
}

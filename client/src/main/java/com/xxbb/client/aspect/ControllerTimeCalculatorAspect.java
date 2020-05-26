package com.xxbb.client.aspect;

import com.xxbb.simpleframework.aop.annotation.Aspect;
import com.xxbb.simpleframework.aop.annotation.Order;
import com.xxbb.simpleframework.aop.aspect.DefaultAspect;
import com.xxbb.simpleframework.core.annotation.Controller;
import com.xxbb.simpleframework.util.LogUtil;
import org.slf4j.Logger;

import java.lang.reflect.Method;

/**
 * @author xxbb
 */
@Aspect(value = Controller.class)
@Order(0)
public class ControllerTimeCalculatorAspect extends DefaultAspect {
    private long timestampCache;
    private final Logger logger= LogUtil.getLogger();
    @Override
    public void before(Class<?> targetClass, Method method, Object[] args) throws Throwable {
        logger.info("开始计时，当前执行类是[{}],执行方法是[{}}，参数是[{}]",
                targetClass.getSimpleName(),method.getName(),args);
        timestampCache=System.currentTimeMillis();
    }

    @Override
    public Object afterReturning(Class<?> targetClass, Method method, Object[] args, Object returnValue) throws Throwable {
        long endTime=System.currentTimeMillis();
        long costTime=System.currentTimeMillis()-timestampCache;
        logger.info("结束计时当前执行类是[{}],执行方法是[{}]，参数是[{}],总耗时：{}",
                targetClass.getSimpleName(),method.getName(),args,costTime);
        return returnValue;
    }

    @Override
    public void afterThrowing(Class<?> targetClass, Method method, Object[] args, Throwable throwable) throws Throwable {
        super.afterThrowing(targetClass, method, args, throwable);
    }
}

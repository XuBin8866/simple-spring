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
@Order(1)
public class ControllerTimeCalculatorAspect2 extends DefaultAspect {
    private final Logger logger= LogUtil.getLogger();
    @Override
    public void before(Class<?> targetClass, Method method, Object[] args) throws Throwable {
        logger.debug("理论上第二个执行的前置方法");

    }
}

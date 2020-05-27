package com.xxbb.sspring.aop;

import org.aspectj.weaver.tools.PointcutExpression;
import org.aspectj.weaver.tools.PointcutParser;
import org.aspectj.weaver.tools.ShadowMatch;

import java.lang.reflect.Method;

/**
 * 解析Aspect表达式并且定位被织入的目标
 * @author xxbb
 */
public class PointcutLocator {
    /**
     * Pointcut解析器，直接给它赋值上AspectJ的所有表达式，以便支持对众多表达式的解析
     * 目前只使用到EXECUTION和WITHIN
     */
    private PointcutParser pointcutParser=PointcutParser.getPointcutParserSupportingSpecifiedPrimitivesAndUsingContextClassloaderForResolution(
            PointcutParser.getAllSupportedPointcutPrimitives()
    );

    /**
     * 表达式解析器
     */
    private PointcutExpression pointcutExpression;

    public PointcutLocator(String expression){
        this.pointcutExpression=pointcutParser.parsePointcutExpression(expression);
    }

    /**
     * 判断传入的Class对象是否是Aspect类的目标代理类，即匹配Pointcut表达式（初筛）
     * @param targetClass 目标类
     * @return 是否匹配
     */
    public boolean roughMatches(Class<?> targetClass){
        //只能校验within语法，其他语法的表达式直接返回true
        return pointcutExpression.couldMatchJoinPointsInType(targetClass);
    }

    /**
     * 判断传入的Method对象是否是Aspect的目标代理方法，即匹配Pointcut表达式（精确筛选）
     * @param method
     * @return
     */
    public boolean accurateMatches(Method method){
        ShadowMatch shadowMatch=pointcutExpression.matchesMethodExecution(method);
        return shadowMatch.alwaysMatches();
    }
}

package com.training.core.aop;

import com.training.core.util.LogUtil;
import com.training.sysmanager.entity.AclUser;
import org.aspectj.lang.annotation.SuppressAjWarnings;

/**
 * Created by Athos on 2016-07-31.
 */
@SuppressAjWarnings("adviceDidNotMatch")
public aspect LogAspect {
    //记录执行时间切点
    pointcut countTimePointcut() : execution (* *.*(..)) && @annotation(com.training.core.annotation.CountTime);
    //记录所有异常切点
    pointcut afterTrowingPointcut() : execution (* *.*(..));

//    before() : countTimePointcut()
//            {
//                System.out.println(thisJoinPoint.getSignature().getName());
//            }
//    after() : countTimePointcut()
//            {
//                System.out.println(thisJoinPoint.getSignature().getName()+":after");
//            }

//    after() returning : executionPointcut()
//            {
//                System.out.println(thisJoinPoint.getSignature().getName()+": returning");
//            }

    Object around() : countTimePointcut()
            {
                long startTime = System.currentTimeMillis();
                proceed();
                long endTime = System.currentTimeMillis();
                LogUtil.countTimeLog("类:"+thisJoinPoint.getSignature().getClass().getName()+">>方法:"+thisJoinPoint.getSignature().getName()+"运算时间:" + (endTime - startTime)+"   毫秒");
                return new AclUser();
            }

    //记录所有异常日志
    after() throwing (Exception ex):afterTrowingPointcut()
            {
                LogUtil.errorLog("类:"+thisJoinPoint.getSignature().getClass().getName()+">>方法:"+thisJoinPoint.getSignature().getName()+">>异常:"+ex.getMessage());
                LogUtil.errorLog(thisJoinPoint.getSourceLocation());
            }
}

package com.unjlams.SpringAop;


import org.aspectj.lang.ProceedingJoinPoint;

/**
 * Created by UnjlAms on 2017/9/21.
 */

//aop 通知类
//@Aspect
public class PrepareNotify {

//    批量修改
//    @Pointcut("execution(* com.unjlams.SpringAop.firstAopImpl.*(..))")
//    public void firstaop(){}

//    前置通知: 目标方法运行之前调用
//    @Before("execution(* com.unjlams.SpringAop.firstAopImpl.*(..))")
//    @Before("PrepareNotify.firstaop()")
    public void before(){
        System.out.println("这是前置通知");
    }

//    后置通知: 目标方法运行之后调用(异常出现不会调用)
//    @AfterReturning("execution(* com.unjlams.SpringAop.firstAopImpl.*(..))")
    public void afterReturning(){
        System.out.println("这是异常不调用后置通知");
    }

//    环绕通知: 在目标方法之前和之后都调用
//    @Around("execution(* com.unjlams.SpringAop.firstAopImpl.*(..))")
    public Object around(ProceedingJoinPoint pro) throws Throwable {
        System.out.println("这是环绕通知之前");
        Object proceed = pro.proceed();
        System.out.println("这是环绕通知之后");
        return proceed;
    }

//    异常拦截通知: 如果出现异常就会调用
//    @AfterThrowing("execution(* com.unjlams.SpringAop.firstAopImpl.*(..))")
    public void afterException(){
        System.out.println("这是异常通知");
    }


//    后置通知: 在目标方法运行之后调用(无论是否出现异常都会调用)
//    @After("execution(* com.unjlams.SpringAop.firstAopImpl.*(..))")
    public void after(){
        System.out.println("这是异常调用后置通知");
    }
}

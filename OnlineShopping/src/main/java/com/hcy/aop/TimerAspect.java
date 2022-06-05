package com.hcy.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

@Component // 将当前类的对象创建使用维护交由Spring容器维护
@Aspect // 将当前类标记为切面类
public class TimerAspect {
    @Around("execution(* com.hcy.service.impl.*.*(..))") //关注哪些方法
    public Object around(ProceedingJoinPoint pjp) throws Throwable {
        
        long start = System.currentTimeMillis();
        Object proceed = pjp.proceed(); // 调用目标方法
        long end = System.currentTimeMillis();
        long time = end - start;
        
        Object target = pjp.getTarget();
        String className = target.getClass().getName();////当前执行的方法所属的类、包
    
        MethodSignature signature = (MethodSignature) pjp.getSignature();
        String methodName = signature.getName();  //当前执行的方法名称
        
        System.out.println(className + "中的" + methodName + "方法" + "耗时：" + time + "ms");
        return proceed;
    }
}

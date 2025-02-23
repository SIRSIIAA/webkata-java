package sirsiiaa.webkata.java.service.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class SurroundingsAspect {
    /*
     * 1. 环绕增强必须携带返回值，该obj即为环绕方法的返回值
     * 2. 环绕增强使用ProceedingJoinPoint获取原方法上下文信息
     * 3. 使用环绕通知需要
     */
    @Around("sirsiiaa.webkata.java.service.aspects.LogAspect.pointcut()")
    public Object commit(ProceedingJoinPoint joinPoint) throws Throwable {
        var args = joinPoint.getArgs();
        Object res = null;

        /*
         * 在多个增强中需要共享的变量
         */
        long startTime = System.currentTimeMillis();
        try {
            res = joinPoint.proceed();
        } catch (Throwable e) {

        } finally {
            long duration = System.currentTimeMillis() - startTime;
            System.out.println(joinPoint.getClass().getSimpleName() + "spends" + duration);
        }
        return res;
    }

}

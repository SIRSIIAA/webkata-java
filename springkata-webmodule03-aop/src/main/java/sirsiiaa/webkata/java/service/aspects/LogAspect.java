package sirsiiaa.webkata.java.service.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.lang.reflect.Modifier;
import java.util.Arrays;

/*
 * step 1 将切面类注入IoC容器
 */
@Component
/*
 * step 2 标记此类为一个切面
 */
@Aspect
public class LogAspect {
    /*
     * step 3
     * 在切面中定义方法，最多4个
     * AOP框架会在将业务代码和切面方法组合成如下形式，使用如下四个注解标记四个切入点
     * try
     *  -- point 1 前置 @Before
     *  service code
     *  -- point 2 返回 @AfterReturning
     * catch
     *  -- point 3 异常 @AfterThrowing
     *  finally
     *  -- point 4 后置 @After
     */

    /*
     * 1. 所有的增强方法都可以获取到JoinPoint对象，JoinPoint包装了目标方法（参数、修饰符、方法名称）、目标方法所在类
     *      将JoinPoint jp 加入切面方法的参数表，若结合returning、throwing使用，jp须是第一个参数
     * 2. AfterReturning切面可以获取到目标方法的返回值
     *      将Object res 加入切面方法的参数表，然后在注解中配置returning字段的值
     * 3. AfterThrowing切面可以获取到目标方法的异常，可使用接口接收
     *      将Throwable exception 加入切面方法的参数表，然后在注解中配置throwing字段的值
     */
    @Before("execution(* sirsiiaa..impl.*.*(..))")
    public void entryPoint(JoinPoint joinPoint) {
        /*
         * 获取方法所属对象
         */
        var clazz = joinPoint.getTarget().getClass().getSimpleName();
        /*
         * 获取方法签名
         */
        var signature = joinPoint.getSignature().getName();
        var modifier = Modifier.toString(joinPoint.getSignature().getModifiers());
        var args = joinPoint.getArgs();
        System.out.println(clazz + " " + signature + " " + modifier + " " + Arrays.toString(args) + " entryPoint");
    }

    @AfterReturning(value = "execution(* sirsiiaa..impl.*.*(..))", returning = "res")
    public void exitPoint(Object res) {
        System.out.println("exitPoint");
    }

    @AfterThrowing(value = "execution(* sirsiiaa..impl.*.*(..))", throwing = "exception")
    public void exceptionPoint(Throwable exception) {
        System.out.println("exception");
    }

    @After("execution(* sirsiiaa..impl.*.*(..))")
    public void afterReturning() {
        System.out.println("after");
    }

}

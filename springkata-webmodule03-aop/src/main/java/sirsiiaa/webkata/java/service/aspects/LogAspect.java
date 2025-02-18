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
     * AOP框架会将业务代码和切面方法组合成如下形式，使用如下四个注解标记四个切入点
     * try
     *  -- point 1 前置 @Before 进入方法之前
     *  service code
     *  -- point 2 返回 @AfterReturning 方法正常返回之后
     * catch
     *  -- point 3 异常 @AfterThrowing 方法抛出异常行
     *  finally
     *  -- point 4 后置 @After 方法执行完毕
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

    /*
     * 在切面中可以调用用于引入@Pointcut的方法，实现重用
     */
    @After("pointcut()")
    public void afterReturning() {
        System.out.println("after");
    }

    /*
     * 1. 提供一个无参数无返回值方法，用以引入@Pointcut注解，来实现切点表达式的重用
     * 2. 切点表达式可以跨类引用，在方法前添加全类名即可
     * 3. 也因2，可以使用一个类将所有的@Pointcut修饰方法封装，该类不需要@Aspects标记，仅使用@Component修饰即可，因为该类不是一个切面类
     */
    @Pointcut("execution(* sirsiiaa..impl.*.*(..))")
    public void pointcut() {

    }

}

package sirsiiaa.webkata.java.service.aspects;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

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
    @Before("execution(* sirsiiaa..impl.*.*(..))")
    public void entryPoint() {
        System.out.println("entryPoint");
    }
    @AfterReturning("execution(* sirsiiaa..impl.*.*(..))")
    public void exitPoint() {
        System.out.println("exitPoint");
    }
}

package sirsiiaa.webkata.java.service.aspects;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/*
 * 事务切面
 */
@Component
@Aspect
@Order(10)
public class TXAspect {
    @Before("execution(* sirsiiaa..impl.*.*(..))")
    public void begin() {
        System.out.printf("Entering %s.begin() \n", this.getClass().getName());
    }

    @AfterReturning("execution(* sirsiiaa..impl.*.*(..))")
    public void commit() {
        System.out.printf("Entering %s.commit() \n", this.getClass().getName());
    }

    @AfterThrowing("execution(* sirsiiaa..impl.*.*(..))")
    public void rollback() {
        System.out.printf("Entering %s.rollback() \n", this.getClass().getName());
    }
}

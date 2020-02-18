package com.yau.diy;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AnnotationPointCut {
    @Pointcut(value = "execution(* com.yau..*.*(..))")
    public void pointCut() {

    }

    // 如果調用的是 UserService 中的 delete()，可以先注釋掉這個函數，只使用 beforeDelete()
    @Before(value = "pointCut()")
    public void before() {
        System.out.println("BEFORE");
    }

    // 為刪除而準備的一個函數
    // 被通知的方法應該要接受一個 int 型的參數，並且這個參數會傳遞到通知中
    // args()中的參數要和通知函數中的參數名一致
    @Before(value = "execution(* com..*.*(int)) && args(id)")
    public void beforeDelete(int id) {
        System.out.println("id = " + id);
        System.out.println("BEFORE");
    }

    @After(value = "pointCut()")
    public void after() {
        System.out.println("AFTER");
    }

    @AfterReturning(value = "pointCut()")
    public void afterReturning() {
        System.out.println("AFTER-RETURNING");
    }

    @Around(value = "pointCut()")
    public Object around(ProceedingJoinPoint jp) throws Throwable {
        System.out.println("B-around");
        Object proceed = jp.proceed();
        System.out.println("A-around");
        return proceed;
    }
}

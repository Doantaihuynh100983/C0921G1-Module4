package vn.codegym.ung_dung_muon_sach.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class BookAspect {

   @AfterReturning(pointcut = "execution(* vn.codegym.ung_dung_muon_sach.controller.BookController.*(..))")
    public void log(JoinPoint joinPoint){
        String name =joinPoint.getSignature().getName();
       System.err.println("is in the position of  "+name);
   }
    @AfterReturning(pointcut = "execution(* vn.codegym.ung_dung_muon_sach.controller.BookController.rent(String))")
    public void status(JoinPoint joinPoint){
        System.err.println("rented a book");
    }
}

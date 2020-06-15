package com.rych.appmailweek6;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MailAspect {

    @After("@annotation(MailAsp)")
    private void afterAddingMovieSendMail(){
        System.out.println("afterAddingMovieSendMail");

    }

}

package com.rych.appmailweek6;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MailAspect {


    private JavaMailSender javaMailSender;

    @Autowired
    public MailAspect(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    @After("@annotation(MailAsp)")
    private void afterAddingMovieSendMail() throws MailException {

        SimpleMailMessage mail = new SimpleMailMessage();
        mail.setTo("*****@gmail.com");
        mail.setFrom("*****@gmail.com");
        mail.setSubject("Test");
        mail.setText("Text2");
        javaMailSender.send(mail);
    }

}


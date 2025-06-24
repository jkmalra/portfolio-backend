package com.jkmalra.Portfolioapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {
    @Autowired
    private JavaMailSender mailSender;
    public void sendContactEmail(ContactForm form){
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo("jaskarans.work@gmail.com");
        message.setSubject(" New Contact Form Submission ");
        message.setText(
                "Name:" + form.getName() + "\n" +
                "Email:" + form.getEmail() + "\n" +
                "Message:" + form.getMessage()
        );
        mailSender.send(message);
    }
}

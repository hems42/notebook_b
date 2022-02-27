package com.notebook_b.org;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

public class main implements CommandLineRunner {
    @Autowired
    private JavaMailSender sender;
    public static void main(String[] args) {




}

    @Override
    public void run(String... args) throws Exception {

            MimeMessage message = sender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message);

            try {
                helper.setTo("eflatun126@gmail.com");
                helper.setText("Greetings :)");
                helper.setSubject("Mail From Spring Boot");
            } catch (MessagingException e) {
                e.printStackTrace();
                System.out.println("hataya düşütü: "+e.getMessage());
            }
            sender.send(message);
        System.out.println("mesaj yollandı");
        }


    }

package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender mailSender;

    public void sendReminderEmail(String toEmail) {

    	 SimpleMailMessage message = new SimpleMailMessage();

         message.setFrom("ankithgunisetti@gmail.com");  // VERIFIED sender
         message.setTo(toEmail);
         message.setSubject("Water Reminder 💧");
         message.setText("Time to drink water!");

         mailSender.send(message);

         System.out.println("Email sent to: " + toEmail);
    }
}

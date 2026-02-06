package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.example.demo.model.User;
import com.example.demo.repository.*;

import java.util.List;

@Component
public class ReminderScheduler {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private EmailService emailService;

    private void sendReminderToAllUsers(String time) {

        System.out.println("Sending reminder for time: " + time);

        List<User> users = userRepository.findAll();

        for (User user : users) {

            emailService.sendReminderEmail(user.getEmail());

        }
    }

    // 8 AM
    @Scheduled(cron = "0 0 8 * * ?")
    public void reminder8AM() {
        sendReminderToAllUsers("8 AM");
    }

    // 10 AM
    @Scheduled(cron = "0 0 10 * * ?")
    public void reminder10AM() {
        sendReminderToAllUsers("10 AM");
    }

    // 12 PM
    @Scheduled(cron = "0 0 12 * * ?")
    public void reminder12PM() {
        sendReminderToAllUsers("12 PM");
    }

    // 2 PM
    @Scheduled(cron = "0 0 14 * * ?")
    public void reminder2PM() {
        sendReminderToAllUsers("2 PM");
    }

    // 4 PM
    @Scheduled(cron = "0 0 16 * * ?")
    public void reminder4PM() {
        sendReminderToAllUsers("4 PM");
    }

    // 6 PM
    @Scheduled(cron = "0 0 18 * * ?")
    public void reminder6PM() {
        sendReminderToAllUsers("6 PM");
    }

    // 8 PM
    @Scheduled(cron = "0 0 20 * * ?")
    public void reminder8PM() {
        sendReminderToAllUsers("8 PM");
    }
}

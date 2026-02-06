package com.example.demo.service;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

@Component
public class ReminderScheduler {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private EmailService emailService;

    // This method sends email to all registered users
    public void sendReminderToAllUsers(String reminderTime) {

        System.out.println("Sending reminder for time: " + reminderTime);
        System.out.println("Current IST time: " + LocalDateTime.now());

        List<User> users = userRepository.findAll();

        if (users.isEmpty()) {
            System.out.println("No users registered.");
            return;
        }

        for (User user : users) {

            try {
                emailService.sendReminderEmail(user.getEmail());
                System.out.println("Email sent to: " + user.getEmail());

            } catch (Exception e) {

                System.out.println("Failed to send email to: " + user.getEmail());
                e.printStackTrace();

            }
        }
    }

    // Scheduler runs at fixed IST times
    @Scheduled(
            cron = "0 0 8,10,12,14,16,18,20 * * ?",
            zone = "Asia/Kolkata"
    )
    public void sendDailyReminders() {

        sendReminderToAllUsers("Scheduled Reminder");

    }

}

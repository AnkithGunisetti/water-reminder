package com.example.demo.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

@Service
public class EmailService {

    @Value("${BREVO_API_KEY}")
    private String apiKey;

    public void sendReminderEmail(String toEmail) {

        try {

            URL url = new URL("https://api.brevo.com/v3/smtp/email");

            HttpURLConnection conn = (HttpURLConnection) url.openConnection();

            conn.setRequestMethod("POST");
            conn.setRequestProperty("accept", "application/json");
            conn.setRequestProperty("api-key", apiKey);
            conn.setRequestProperty("content-type", "application/json");

            conn.setDoOutput(true);

            String json = "{"
                    + "\"sender\":{\"email\":\"ankithkumar0301@gmail.com\"},"
                    + "\"to\":[{\"email\":\"" + toEmail + "\"}],"
                    + "\"subject\":\"Water Reminder 💧\","
                    + "\"textContent\":\"Time to drink water! Stay hydrated.\""
                    + "}";

            OutputStream os = conn.getOutputStream();
            os.write(json.getBytes());
            os.flush();
            os.close();

            int responseCode = conn.getResponseCode();

            if (responseCode == 201) {

                System.out.println("Email sent successfully to: " + toEmail);

            } else {

                System.out.println("Failed to send email. Code: " + responseCode);

            }

        } catch (Exception e) {

            e.printStackTrace();

        }

    }
}

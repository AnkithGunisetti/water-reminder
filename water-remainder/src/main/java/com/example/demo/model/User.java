package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;
    private String password;

    private String reminder1;
    private String reminder2;
    private String reminder3;
    private String reminder4;
    private String reminder5;
    private String reminder6;
    private String reminder7;
    private String reminder8;

    // Getter and Setter for id
    public Long getId() {
        return id;
    }

    // Getter and Setter for email
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    // Getter and Setter for password
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    // Reminder getters and setters

    public String getReminder1() {
        return reminder1;
    }

    public void setReminder1(String reminder1) {
        this.reminder1 = reminder1;
    }

    public String getReminder2() {
        return reminder2;
    }

    public void setReminder2(String reminder2) {
        this.reminder2 = reminder2;
    }

    public String getReminder3() {
        return reminder3;
    }

    public void setReminder3(String reminder3) {
        this.reminder3 = reminder3;
    }

    public String getReminder4() {
        return reminder4;
    }

    public void setReminder4(String reminder4) {
        this.reminder4 = reminder4;
    }

    public String getReminder5() {
        return reminder5;
    }

    public void setReminder5(String reminder5) {
        this.reminder5 = reminder5;
    }

    public String getReminder6() {
        return reminder6;
    }

    public void setReminder6(String reminder6) {
        this.reminder6 = reminder6;
    }

    public String getReminder7() {
        return reminder7;
    }

    public void setReminder7(String reminder7) {
        this.reminder7 = reminder7;
    }

    public String getReminder8() {
        return reminder8;
    }

    public void setReminder8(String reminder8) {
        this.reminder8 = reminder8;
    }
}

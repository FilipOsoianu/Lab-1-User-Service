package com.example.lab_1_user.entities;

import java.util.Date;


public class User {
    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private Date birthDate;

    public User(int id, String firstName, String lastName, String email, Date birthDate) {
        this.id = id;
        this.firstName = firstName;
        this.birthDate = birthDate;
        this.lastName = lastName;
        this.email = email;
    }

    public double getId() {
        return id;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

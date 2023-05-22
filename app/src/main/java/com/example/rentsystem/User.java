package com.example.rentsystem;

public class User {
    String Username,Contact,Occupation,Status;
    public User(){

    }


    public User(String username,  String contact, String occupation, String status) {
        Username = username;
        Contact = contact;
        Occupation = occupation;
        Status = status;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }


    public String getContact() {
        return Contact;
    }

    public void setContact(String contact) {
        Contact = contact;
    }

    public String getOccupation() {
        return Occupation;
    }

    public void setOccupation(String occupation) {
        Occupation = occupation;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }
}

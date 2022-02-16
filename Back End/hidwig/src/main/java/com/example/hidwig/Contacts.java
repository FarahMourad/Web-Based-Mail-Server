package com.example.hidwig;

public class Contacts {
    private String name;
    private String email;
    Contacts(){}
    Contacts(String name , String email){
        this.name = name;
        this.email = email;
    }

    public String getName() {
        return name;
    }
    public String getEmail() {
        return email;
    }
}

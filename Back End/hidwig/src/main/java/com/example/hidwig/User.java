package com.example.hidwig;
//immutable class
public class User {
    private String firstName;
    private String lastName;
    private String mail;
    private String pass;
    private String id;
    public User(){}
    public User(String mail){
        this.mail = mail;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
    public String getId() {
        return id;
    }
    public String getMail() {
        return mail;
    }
    public String getPass() {
        return pass;
    }
    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }

    public void setId(String id) {
        this.id = id;
    }
}

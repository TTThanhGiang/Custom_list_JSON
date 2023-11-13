package com.example.baitap_json;

import java.io.Serializable;

public class User implements Serializable {
    private String firstname;
    private String lastname;
    private String birthday;

    private String username;
    private String password;

    private String phonenumber;
    private String img;

    public User(String firstname, String lastname, String birthday, String username, String password, String phonenumber, String img) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.birthday = birthday;
        this.username = username;
        this.password = password;
        this.phonenumber = phonenumber;
        this.img = img;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
}

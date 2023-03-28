package com.example.shop_online.payload.request;

import javax.persistence.Column;

public class UserRequest {
    private String fullname;
    private  String phone;
    private String password;
    private String email;
    private boolean activated;
    private boolean admin;

    public UserRequest(String fullname, String phone, String password, String email, boolean activated, boolean admin) {
        this.fullname = fullname;
        this.phone = phone;
        this.password = password;
        this.email = email;
        this.activated = activated;
        this.admin = admin;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isActivated() {
        return activated;
    }

    public void setActivated(boolean activated) {
        this.activated = activated;
    }

    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }
}

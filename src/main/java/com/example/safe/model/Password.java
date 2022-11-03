package com.example.safe.model;

public class Password {

    private String password;
    private String contentUser;

    public Password(String password, String contentUser) {
        this.password = password;
        this.contentUser = contentUser;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getContentUser() {
        return contentUser;
    }

    public void setContentUser(String contentUser) {
        this.contentUser = contentUser;
    }
}

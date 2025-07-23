package com.rs.user_service.dto;

public class UserRequest {
    private String username;
    private String password;

    public UserRequest(String userName, String password) {
        this.username = userName;
        this.password = password;
    }

    public UserRequest() {
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
}

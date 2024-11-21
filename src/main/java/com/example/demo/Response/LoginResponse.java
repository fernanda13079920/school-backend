package com.example.demo.Response;

public class LoginResponse {
    String message;
    Boolean status;
    String token;
    String username;
    Long userId;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public LoginResponse() {
    }

    public LoginResponse(String message, Boolean status, String token, String username, Long userId) {
        this.message = message;
        this.status = status;
        this.token = token;
        this.username = username;
        this.userId = userId;
    }

    public LoginResponse(String message) {
        this.message = message;
        this.status = false;
        this.token = "";
        this.username = "";
        this.userId = null;
    }

    public LoginResponse(String message, Boolean status) {
        this.message = message;
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "LoginResponse [message=" + message + ", status=" + status + ", token=" + token + ", username="
                + username + ", userId=" + userId + "]";
    }
}

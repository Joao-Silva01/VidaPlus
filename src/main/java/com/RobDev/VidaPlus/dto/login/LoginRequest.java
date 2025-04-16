package com.RobDev.VidaPlus.dto.login;

import com.RobDev.VidaPlus.validations.email.EmailValid;

public class LoginRequest {

    @EmailValid
    private String email;
    private String password;

    public LoginRequest(){}

    public LoginRequest(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

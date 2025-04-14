package com.RobDev.VidaPlus.dto.administrator;

import com.RobDev.VidaPlus.validations.email.EmailValid;

public class UpdateAdminRequest {

    private String name;
    @EmailValid(value = "Update")
    private String email;
    private String password;

    public UpdateAdminRequest(){

    }

    public UpdateAdminRequest(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

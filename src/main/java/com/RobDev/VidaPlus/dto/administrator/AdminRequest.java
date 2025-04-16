package com.RobDev.VidaPlus.dto.administrator;


import com.RobDev.VidaPlus.validations.email.EmailValid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class AdminRequest {

    @NotBlank(message = "Name cannot be empty or null")
    @Pattern(regexp = "^[a-zA-Z_. ]+$", message = "Name invalid")
    @Size(max = 50 , message = "invalid name size")
    private String name;

    @EmailValid
    private String email;

    @NotBlank(message = "Password cannot be empty or null")
    @Size(max = 150 , message = "invalid password size")
    private String password;

    private AdminRequest() {
    }

    public AdminRequest(String name, String email, String password) {
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

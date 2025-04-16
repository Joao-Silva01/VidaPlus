package com.RobDev.VidaPlus.dto.patiente;

import com.RobDev.VidaPlus.entities.enums.Sex;
import com.RobDev.VidaPlus.entities.Patient;
import com.RobDev.VidaPlus.validations.cpf.CpfValid;
import com.RobDev.VidaPlus.validations.email.EmailValid;


import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import org.springframework.beans.BeanUtils;

import java.io.Serializable;
import java.sql.Timestamp;

public class CreatePatientRequest implements Serializable {

    @NotBlank(message = "Name cannot be empty or null")
    @Pattern(regexp = "^[a-zA-Z ]+$", message = "Name can only contain letters")
    @Size(max = 40, message = "invalid name length")
    private String name;

    @NotNull(message = "Birthdate cannot be null")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "America/Sao_Paulo")
    private Timestamp birth_date;


    @Size(max = 10, message = "invalid phone length")
    private String phone;

    @NotBlank(message = "Password cannot be empty or null")
    @Size(max = 150, message = "invalid password length")
    private String password;

    @NotNull(message = "Sex cannot be null")
    private Sex sex;

    @EmailValid
    private String email;

    @CpfValid
    private String document;

    public CreatePatientRequest(){

    }

    public CreatePatientRequest(Patient patient) {
        BeanUtils.copyProperties(patient, this);

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name.strip();
    }

    public Timestamp getBirth_date() {
        return birth_date;
    }

    public void setBirth_date(Timestamp birth_date) {
        this.birth_date = birth_date;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone.strip();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password.strip();
    }

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    public String getEmail() {
        return email.strip();
    }

    public void setEmail(String email) {
        this.email = email.strip();
    }

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document.strip();
    }
}

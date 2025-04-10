package com.RobDev.VidaPlus.dto.patiente;

import com.RobDev.VidaPlus.entities.enums.Sex;
import com.RobDev.VidaPlus.entities.Patient;
import com.RobDev.VidaPlus.validations.cpf.CpfValid;
import com.RobDev.VidaPlus.validations.email.EmailValid;
import org.springframework.beans.BeanUtils;

import java.io.Serializable;
import java.sql.Timestamp;

public class CreatePatientRequest implements Serializable {

    private String name;
    private Timestamp birth_date;
    private String phone;
    private String password;
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
        this.name = name;
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
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }
}

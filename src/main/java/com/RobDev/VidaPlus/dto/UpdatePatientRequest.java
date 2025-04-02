package com.RobDev.VidaPlus.dto;

import com.RobDev.VidaPlus.Entities.Enums.Sex;
import com.RobDev.VidaPlus.Entities.Patient;
import org.springframework.beans.BeanUtils;

import java.io.Serializable;
import java.sql.Timestamp;

public class UpdatePatientRequest implements Serializable {

    private String name;
    private Timestamp birth_date;
    private String phone;
    private String password;
    private Sex sex;
    private String email;

    public UpdatePatientRequest(){

    }

    public UpdatePatientRequest(Patient patient) {
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
}

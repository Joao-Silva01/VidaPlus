package com.RobDev.VidaPlus.dto.patiente;

import com.RobDev.VidaPlus.Entities.Enums.Sex;
import com.RobDev.VidaPlus.Entities.Patient;
import org.springframework.beans.BeanUtils;

import java.io.Serializable;
import java.sql.Timestamp;

public class PatientResponse implements Serializable {

    private long id;
    private String name;
    private Timestamp birth_date;
    private String phone;
    private Sex sex;
    private String email;
    private String document;

    public PatientResponse(){

    }

    public PatientResponse(Patient patient) {
        BeanUtils.copyProperties(patient, this);

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

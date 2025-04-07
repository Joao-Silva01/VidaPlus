package com.RobDev.VidaPlus.dto.patiente;

import com.RobDev.VidaPlus.entities.enums.Sex;
import com.RobDev.VidaPlus.dto.consultation.ConsultationPatientResponse;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class AllConsultationsPatientResponse {
    private long id;
    private String name;
    private Timestamp birth_date;
    private String phone;
    private Sex sex;
    private String email;
    private String document;
    private List<ConsultationPatientResponse> consultations = new ArrayList<>();

    public AllConsultationsPatientResponse(){}

    public AllConsultationsPatientResponse(long id, String name, Timestamp birth_date, String phone, Sex sex, String email, String document) {
        this.id = id;
        this.name = name;
        this.birth_date = birth_date;
        this.phone = phone;
        this.sex = sex;
        this.email = email;
        this.document = document;
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

    public List<ConsultationPatientResponse> getConsultations() {
        return consultations;
    }

    public void setConsultations(List<ConsultationPatientResponse> consultations) {
        this.consultations = consultations;
    }
}

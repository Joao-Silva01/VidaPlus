package com.RobDev.VidaPlus.dto.patiente;

import com.RobDev.VidaPlus.entities.enums.Sex;
import com.RobDev.VidaPlus.entities.Patient;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.beans.BeanUtils;

import java.io.Serializable;
import java.sql.Timestamp;

public class PatientResponse implements Serializable {

    private long id;
    private String name;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "America/Sao_Paulo")
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
        // Retorna o número formatado com espaço
        return phone.replaceFirst("(\\d{2})(\\d{9})", "$1 $2");
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
        //retorna o cpf formatado '111.111.111-11'
        return document.replaceFirst("(\\d{3})(\\d{3})(\\d{3})(\\d{2})", "$1.$2.$3-$4");
    }

    public void setDocument(String document) {
        this.document = document;
    }
}

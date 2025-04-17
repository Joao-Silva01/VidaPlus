package com.RobDev.VidaPlus.dto.patiente;

import com.RobDev.VidaPlus.entities.enums.Sex;
import com.RobDev.VidaPlus.entities.Patient;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import org.springframework.beans.BeanUtils;

import java.io.Serializable;
import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class PatientResponse implements Serializable {

    private long id;
    private String name;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "America/Sao_Paulo")
    private LocalDate birth_date;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String phone;
    private Sex sex;
    private String email;
    private String document;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm", timezone = "America/Sao_Paulo")
    private LocalDateTime registerMoment;

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

    public LocalDate getBirth_date() {
        return birth_date;
    }

    public void setBirth_date(LocalDate birth_date) {
        this.birth_date = birth_date;
    }

    public String getPhone() {
        // Retorna o número formatado com espaço
        if(phone != null) {
            return phone.replaceFirst("(\\d{2})(\\d{9})", "$1 $2");
        }
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
        //retorna o cpf formatado '111.111.111-11'
        return document.replaceFirst("(\\d{3})(\\d{3})(\\d{3})(\\d{2})", "$1.$2.$3-$4");
    }

    public void setDocument(String document) {
        this.document = document;
    }

    public LocalDateTime getRegisterMoment() {
        return registerMoment;
    }

    public void setRegisterMoment(LocalDateTime registerMoment) {
        this.registerMoment = registerMoment;
    }
}

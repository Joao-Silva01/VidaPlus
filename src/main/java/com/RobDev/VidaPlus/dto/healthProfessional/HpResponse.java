package com.RobDev.VidaPlus.dto.healthProfessional;

import com.RobDev.VidaPlus.entities.enums.HealthProfession;
import com.RobDev.VidaPlus.entities.HealthProfessional;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.beans.BeanUtils;

import java.io.Serializable;
import java.sql.Timestamp;

public class HpResponse implements Serializable {

    private long id;
    private String name;
    private String email;
    private String phone;
    private String document;
    private HealthProfession profession;
    private String specialty;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm", timezone = "America/Sao_Paulo")
    private Timestamp registerMoment;

    public HpResponse() {
    }

    public HpResponse(HealthProfessional entity) {
        BeanUtils.copyProperties(entity, this);
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        // Retorna o número formatado com espaço
        return phone.replaceFirst("(\\d{2})(\\d{9})", "$1 $2");
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public HealthProfession getProfession() {
        return profession;
    }

    public void setProfession(HealthProfession profession) {
        this.profession = profession;
    }

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    public String getDocument() {
        //retorna o cpf formatado '111.111.111-11'
        return document.replaceFirst("(\\d{3})(\\d{3})(\\d{3})(\\d{2})", "$1.$2.$3-$4");
    }

    public void setDocument(String document) {
        this.document = document.strip();
    }

    public Timestamp getRegisterMoment() {
        return registerMoment;
    }

    public void setRegisterMoment(Timestamp registerMoment) {
        this.registerMoment = registerMoment;
    }
}

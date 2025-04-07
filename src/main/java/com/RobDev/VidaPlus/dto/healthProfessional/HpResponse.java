package com.RobDev.VidaPlus.dto.healthProfessional;

import com.RobDev.VidaPlus.entities.enums.HealthProfession;
import com.RobDev.VidaPlus.entities.HealthProfessional;
import org.springframework.beans.BeanUtils;

import java.io.Serializable;

public class HpResponse implements Serializable {

    private long id;
    private String name;
    private String email;
    private String phone;
    private HealthProfession profession;
    private String specialty;

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
        return phone;
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
}

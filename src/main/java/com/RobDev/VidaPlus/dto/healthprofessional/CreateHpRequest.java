package com.RobDev.VidaPlus.dto.healthprofessional;

import com.RobDev.VidaPlus.Entities.Enums.HealthProfession;
import com.RobDev.VidaPlus.Entities.Enums.UserRole;
import com.RobDev.VidaPlus.Entities.HealthProfessional;
import org.springframework.beans.BeanUtils;

import java.io.Serializable;

public class CreateHpRequest implements Serializable {

    private String name;
    private String email;
    private String phone;
    private String password;
    private HealthProfession profession;
    private String specialty;

    public CreateHpRequest() {
    }

    public CreateHpRequest(HealthProfessional entity) {
        BeanUtils.copyProperties(entity, this);
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

package com.RobDev.VidaPlus.dto.healthProfessional;

import com.RobDev.VidaPlus.entities.enums.HealthProfession;
import com.RobDev.VidaPlus.entities.HealthProfessional;
import com.RobDev.VidaPlus.validations.email.EmailValid;
import jakarta.validation.constraints.Size;
import org.springframework.beans.BeanUtils;

import java.io.Serializable;

public class CreateHpRequest implements Serializable {

    @Size(max = 50, message = "invalid name size")
    private String name;

    @EmailValid
    private String email;

    @Size(max = 11, message = "invalid phone size")
    private String phone;

    @Size(max = 150, message = "invalid password size")
    private String password;
    private HealthProfession profession;

    @Size(max = 100, message = "invalid specialty size")
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

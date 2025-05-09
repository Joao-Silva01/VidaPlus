package com.RobDev.VidaPlus.dto.healthProfessional;

import com.RobDev.VidaPlus.entities.enums.HealthProfession;
import com.RobDev.VidaPlus.entities.HealthProfessional;
import com.RobDev.VidaPlus.validations.cpf.CpfValid;
import com.RobDev.VidaPlus.validations.email.EmailValid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import org.springframework.beans.BeanUtils;

import java.io.Serializable;

public class CreateHpRequest implements Serializable {

    @NotBlank(message = "Name cannot be empty or null")
    @Pattern(regexp = "^[a-zA-Z ]+$", message = "Name can only contain letters")
    @Size(max = 50, message = "invalid name size")
    private String name;

    @EmailValid
    private String email;

    @Size(max = 11, message = "invalid phone size")
    private String phone;

    @NotBlank(message = "Password cannot be empty or null")
    @Size(max = 150, message = "invalid password size")
    private String password;

    @NotBlank(message = "Signature cannot be empty or null")
    @Size(max = 100, message = "invalid signature size")
    private String signature;

    @CpfValid
    private String document;

    @NotNull(message = "Profession cannot be null")
    private HealthProfession profession;

    @NotBlank(message = "Specialty cannot be empty or null")
    @Pattern(regexp = "^[a-zA-Z ]+$", message = "Specialty can only contain letters")
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
        this.name = name.strip();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email.strip();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone.strip();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password.strip();
    }

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document.strip();
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

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }
}

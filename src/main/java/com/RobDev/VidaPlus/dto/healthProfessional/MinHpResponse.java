package com.RobDev.VidaPlus.dto.healthProfessional;

import com.RobDev.VidaPlus.entities.enums.HealthProfession;


// Usado como resposta, serve para retornar dados do professional de forma reduzida
public class MinHpResponse {

    private Long id;
    private String name;
    private String email;
    private HealthProfession profession;

    public MinHpResponse() {

    }

    public MinHpResponse(Long id, String name, String email, HealthProfession profession) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.profession = profession;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public HealthProfession getProfession() {
        return profession;
    }

    public void setProfession(HealthProfession profession) {
        this.profession = profession;
    }
}

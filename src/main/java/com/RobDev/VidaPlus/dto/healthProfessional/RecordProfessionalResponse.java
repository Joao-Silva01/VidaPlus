package com.RobDev.VidaPlus.dto.healthProfessional;

import com.RobDev.VidaPlus.entities.enums.HealthProfession;

public class RecordProfessionalResponse {

    private Long id;
    private String name;
    private HealthProfession profession;

    public RecordProfessionalResponse() {

    }

    public RecordProfessionalResponse(Long id, String name, HealthProfession profession) {
        this.id = id;
        this.name = name;
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

    public HealthProfession getProfession() {
        return profession;
    }

    public void setProfession(HealthProfession profession) {
        this.profession = profession;
    }


}

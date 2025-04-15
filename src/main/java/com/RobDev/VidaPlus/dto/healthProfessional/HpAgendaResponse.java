package com.RobDev.VidaPlus.dto.healthProfessional;


import com.RobDev.VidaPlus.dto.agenda.MinAgendaResponse;
import com.RobDev.VidaPlus.entities.enums.HealthProfession;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

// Usado como resposta, para trazer os dados do profissional e toda(s) sua(s) agenda/tarefas
public class HpAgendaResponse implements Serializable {

    private long id;
    private String name;
    private String email;
    private String phone;
    private String document;
    private HealthProfession profession;
    private String specialty;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm", timezone = "America/Sao_Paulo")
    private Timestamp registerMoment;

    private List<MinAgendaResponse> scheduling = new ArrayList<>();

    public HpAgendaResponse(){

    }

    public HpAgendaResponse(long id, String name, String email, String phone,
                            String document, HealthProfession profession,
                            String specialty, Timestamp registerMoment) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.document = document;
        this.profession = profession;
        this.specialty = specialty;
        this.registerMoment = registerMoment;
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

    public String getDocument() {
        //retorna o cpf formatado '111.111.111-11'
        return document.replaceFirst("(\\d{3})(\\d{3})(\\d{3})(\\d{2})", "$1.$2.$3-$4");
    }

    public void setDocument(String document) {
        this.document = document;
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

    public Timestamp getRegisterMoment() {
        return registerMoment;
    }

    public void setRegisterMoment(Timestamp registerMoment) {
        this.registerMoment = registerMoment;
    }

    public List<MinAgendaResponse> getScheduling() {
        return scheduling;
    }

    public void setScheduling(List<MinAgendaResponse> scheduling) {
        this.scheduling = scheduling;
    }
}

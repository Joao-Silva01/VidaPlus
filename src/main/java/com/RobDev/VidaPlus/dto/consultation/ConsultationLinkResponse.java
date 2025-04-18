package com.RobDev.VidaPlus.dto.consultation;

import com.RobDev.VidaPlus.dto.healthProfessional.HpResponse;
import com.RobDev.VidaPlus.dto.healthProfessional.MinHpResponse;
import com.RobDev.VidaPlus.entities.enums.Status;

public class ConsultationLinkResponse {

    private String consultationLink;
    private Status status;
    private MinHpResponse professional;

    public ConsultationLinkResponse(){

    }

    public ConsultationLinkResponse(String consultationLink, Status status, MinHpResponse professional) {
        this.consultationLink = consultationLink;
        this.status = status;
        this.professional = professional;
    }

    public String getConsultationLink() {
        return consultationLink;
    }

    public void setConsultationLink(String consultationLink) {
        this.consultationLink = consultationLink;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public MinHpResponse getProfessional() {
        return professional;
    }

    public void setProfessional(MinHpResponse professional) {
        this.professional = professional;
    }
}

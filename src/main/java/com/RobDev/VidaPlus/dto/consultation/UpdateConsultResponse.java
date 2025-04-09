package com.RobDev.VidaPlus.dto.consultation;

import com.RobDev.VidaPlus.entities.enums.Modality;
import com.RobDev.VidaPlus.entities.enums.Status;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.math.BigDecimal;
import java.util.Date;

public class UpdateConsultResponse {

    private long id;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "America/Sao_Paulo")
    private Date consultationMoment;
    private String diagnostic;
    private String symptoms;
    private BigDecimal ConsultationFee;
    private String consultationLink;
    private Modality type;
    private Status status;

    public UpdateConsultResponse(){}

    public UpdateConsultResponse(long id, Date consultationMoment, String diagnostic, String symptoms,
                                 BigDecimal consultationFee, String consultationLink, Modality type, Status status) {
        this.id = id;
        this.consultationMoment = consultationMoment;
        this.diagnostic = diagnostic;
        this.symptoms = symptoms;
        ConsultationFee = consultationFee;
        this.consultationLink = consultationLink;
        this.type = type;
        this.status = status;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getConsultationMoment() {
        return consultationMoment;
    }

    public void setConsultationMoment(Date consultationMoment) {
        this.consultationMoment = consultationMoment;
    }

    public String getDiagnostic() {
        return diagnostic;
    }

    public void setDiagnostic(String diagnostic) {
        this.diagnostic = diagnostic;
    }

    public String getSymptoms() {
        return symptoms;
    }

    public void setSymptoms(String symptoms) {
        this.symptoms = symptoms;
    }

    public BigDecimal getConsultationFee() {
        return ConsultationFee;
    }

    public void setConsultationFee(BigDecimal consultationFee) {
        ConsultationFee = consultationFee;
    }

    public String getConsultationLink() {
        return consultationLink;
    }

    public void setConsultationLink(String consultationLink) {
        this.consultationLink = consultationLink;
    }

    public Modality getType() {
        return type;
    }

    public void setType(Modality type) {
        this.type = type;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}

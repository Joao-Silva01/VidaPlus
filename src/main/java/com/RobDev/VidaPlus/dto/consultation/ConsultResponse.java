package com.RobDev.VidaPlus.dto.consultation;

import com.RobDev.VidaPlus.Entities.Enums.Modality;
import com.RobDev.VidaPlus.Entities.Enums.Status;
import com.RobDev.VidaPlus.Entities.HealthProfessional;
import com.RobDev.VidaPlus.Entities.Patient;
import com.RobDev.VidaPlus.Entities.Prescription;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class ConsultResponse implements Serializable {

    private long id;
    private Date consultationMoment;
    private String diagnostic;
    private String symptoms;
    private BigDecimal ConsultationFee;
    private String consultationLink;
    private Modality type;
    private Status status;
    private Patient patient;
    private HealthProfessional professional;
    private Prescription prescription;

    public ConsultResponse() {
    }

    public ConsultResponse(long id, Date consultationMoment, String diagnostic, String symptoms, BigDecimal consultationFee, String consultationLink, Modality type, Status status, Patient patient, HealthProfessional professional, Prescription prescription) {
        this.id = id;
        this.consultationMoment = consultationMoment;
        this.diagnostic = diagnostic;
        this.symptoms = symptoms;
        ConsultationFee = consultationFee;
        this.consultationLink = consultationLink;
        this.type = type;
        this.status = status;
        this.patient = patient;
        this.professional = professional;
        this.prescription = prescription;
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

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public HealthProfessional getProfessional() {
        return professional;
    }

    public void setProfessional(HealthProfessional professional) {
        this.professional = professional;
    }

    public Prescription getPrescription() {
        return prescription;
    }

    public void setPrescription(Prescription prescription) {
        this.prescription = prescription;
    }
}

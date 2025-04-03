package com.RobDev.VidaPlus.dto.consultation;

import com.RobDev.VidaPlus.Entities.Enums.Modality;
import com.RobDev.VidaPlus.Entities.Enums.Status;
import com.RobDev.VidaPlus.Entities.HealthProfessional;
import com.RobDev.VidaPlus.Entities.Patient;
import com.RobDev.VidaPlus.Entities.Prescription;
import com.RobDev.VidaPlus.dto.prescription.PrescriptionRequest;
import jakarta.persistence.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class CreateConsultRequest implements Serializable {

    private Date consultationMoment;
    private String diagnostic;
    private String symptoms;
    private BigDecimal ConsultationFee;
    private String consultationLink;
    private Modality type;
    private Status status;
    private long patient_id;
    private PrescriptionRequest prescription;

    public CreateConsultRequest() {
    }

    public CreateConsultRequest(Date consultationMoment, String diagnostic, String symptoms, BigDecimal consultationFee, String consultationLink, Modality type, Status status, long patient_id, PrescriptionRequest prescription) {
        this.consultationMoment = consultationMoment;
        this.diagnostic = diagnostic;
        this.symptoms = symptoms;
        ConsultationFee = consultationFee;
        this.consultationLink = consultationLink;
        this.type = type;
        this.status = status;
        this.patient_id = patient_id;
        this.prescription = prescription;
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

    public long getPatient_id() {
        return patient_id;
    }

    public void setPatient_id(long patient_id) {
        this.patient_id = patient_id;
    }

    public PrescriptionRequest getPrescription() {
        return prescription;
    }

    public void setPrescription(PrescriptionRequest prescription) {
        this.prescription = prescription;
    }
}

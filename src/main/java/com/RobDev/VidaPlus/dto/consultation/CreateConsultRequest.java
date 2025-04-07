package com.RobDev.VidaPlus.dto.consultation;

import com.RobDev.VidaPlus.entities.enums.Modality;
import com.RobDev.VidaPlus.entities.enums.Status;
import com.RobDev.VidaPlus.dto.hospitalAdmission.HospitalAdmissionRequest;
import com.RobDev.VidaPlus.dto.medicalExamination.CreateExamRequest;
import com.RobDev.VidaPlus.dto.prescription.PrescriptionRequest;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CreateConsultRequest implements Serializable {

    private Date consultationMoment;
    private String diagnostic;
    private String symptoms;
    private BigDecimal consultationFee;
    private String consultationLink;
    private Modality type;
    private Status status;
    private long patient_id;
    private long professional_id;
    private PrescriptionRequest prescription;
    private List<CreateExamRequest> requestedExams = new ArrayList<>();
    private HospitalAdmissionRequest hospitalization;

    public CreateConsultRequest() {
    }

    public CreateConsultRequest(Date consultationMoment, String diagnostic, String symptoms,
                                BigDecimal consultationFee, String consultationLink, Modality type,
                                Status status, long patient_id, long professional_id,
                                PrescriptionRequest prescription, HospitalAdmissionRequest hospitalization) {
        this.consultationMoment = consultationMoment;
        this.diagnostic = diagnostic;
        this.symptoms = symptoms;
        this.consultationFee = consultationFee;
        this.consultationLink = consultationLink;
        this.type = type;
        this.status = status;
        this.patient_id = patient_id;
        this.professional_id = professional_id;
        this.prescription = prescription;
        this.hospitalization = hospitalization;
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
        return consultationFee;
    }

    public void setConsultationFee(BigDecimal consultationFee) {
        this.consultationFee = consultationFee;
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

    public long getProfessional_id() {
        return professional_id;
    }

    public void setProfessional_id(long professional_id) {
        this.professional_id = professional_id;
    }

    public PrescriptionRequest getPrescription() {
        return prescription;
    }

    public void setPrescription(PrescriptionRequest prescription) {
        this.prescription = prescription;
    }

    public List<CreateExamRequest> getRequestedExams() {
        return requestedExams;
    }

    public void setRequestedExams(List<CreateExamRequest> requestedExams) {
        this.requestedExams = requestedExams;
    }

    public HospitalAdmissionRequest getHospitalization() {
        return hospitalization;
    }

    public void setHospitalization(HospitalAdmissionRequest hospitalization) {
        this.hospitalization = hospitalization;
    }
}

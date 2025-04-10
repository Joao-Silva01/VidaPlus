package com.RobDev.VidaPlus.dto.consultation;

import com.RobDev.VidaPlus.entities.enums.Modality;
import com.RobDev.VidaPlus.entities.enums.Status;
import com.RobDev.VidaPlus.dto.healthProfessional.HpResponse;
import com.RobDev.VidaPlus.dto.hospitalAdmission.HospitalAdmissionResponse;
import com.RobDev.VidaPlus.dto.medicalExamination.ExamResponse;
import com.RobDev.VidaPlus.dto.patiente.PatientResponse;
import com.RobDev.VidaPlus.dto.prescription.PrescriptionResponse;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.annotation.Nullable;
import jakarta.persistence.Column;
import org.springframework.format.annotation.NumberFormat;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ConsultResponse implements Serializable {

    private long id;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime consultationMoment;
    private String diagnostic;
    private String symptoms;
    private BigDecimal ConsultationFee;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String consultationLink;
    private Modality type;
    private Status status;
    private PatientResponse patient;
    private HpResponse professional;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private PrescriptionResponse prescription;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<ExamResponse> requestedExams = new ArrayList<>();

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private HospitalAdmissionResponse hospitalization;

    public ConsultResponse() {
    }

    public ConsultResponse(long id, LocalDateTime consultationMoment, String diagnostic, String symptoms, BigDecimal consultationFee, String consultationLink, Modality type, Status status, PatientResponse patient, HpResponse professional, PrescriptionResponse prescription, HospitalAdmissionResponse hospitalization) {
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
        this.hospitalization = hospitalization;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalDateTime getConsultationMoment() {
        return consultationMoment;
    }

    public void setConsultationMoment(LocalDateTime consultationMoment) {
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

    public PatientResponse getPatient() {
        return patient;
    }

    public void setPatient(PatientResponse patient) {
        this.patient = patient;
    }

    public HpResponse getProfessional() {
        return professional;
    }

    public void setProfessional(HpResponse professional) {
        this.professional = professional;
    }

    public PrescriptionResponse getPrescription() {
        return prescription;
    }

    public void setPrescription(PrescriptionResponse prescription) {
        this.prescription = prescription;
    }

    public List<ExamResponse> getRequestedExams() {
        return requestedExams;
    }

    public void setRequestedExams(List<ExamResponse> requestedExams) {
        this.requestedExams = requestedExams;
    }

    public HospitalAdmissionResponse getHospitalization() {
        return hospitalization;
    }

    public void setHospitalization(HospitalAdmissionResponse hospitalization) {
        this.hospitalization = hospitalization;
    }
}

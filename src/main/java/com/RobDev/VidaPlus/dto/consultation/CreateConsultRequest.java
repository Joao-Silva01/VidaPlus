package com.RobDev.VidaPlus.dto.consultation;

import com.RobDev.VidaPlus.dto.hospitalAdmission.CreateHospitalAdmissionRequest;
import com.RobDev.VidaPlus.entities.enums.Modality;

import com.RobDev.VidaPlus.dto.medicalExamination.CreateExamRequest;
import com.RobDev.VidaPlus.dto.prescription.PrescriptionRequest;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.io.Serializable;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class CreateConsultRequest implements Serializable {

    @NotNull(message = "Date cannot be null")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime consultationMoment;

    @NotBlank(message = "Diagnostic cannot be empty or null")
    @Size(max = 200, message = "invalid diagnostic size")
    private String diagnostic;

    @NotBlank(message = "Symptoms cannot be empty or null")
    @Size(max = 200, message = "invalid symptoms size")
    private String symptoms;

    @NotNull(message = "Type cannot be null")
    private Modality type;

    @NotNull(message = "Patient cannot be null")
    private long patient_id;

    @NotNull(message = "Professional cannot be null")
    private long professional_id;

    private PrescriptionRequest prescription;
    private List<CreateExamRequest> requestedExams = new ArrayList<>();
    private CreateHospitalAdmissionRequest hospitalization;

    public CreateConsultRequest() {
    }

    public CreateConsultRequest(LocalDateTime consultationMoment, String diagnostic, String symptoms,
                                Modality type, long patient_id,
                                long professional_id, PrescriptionRequest prescription,
                                CreateHospitalAdmissionRequest hospitalization) {
        this.consultationMoment = consultationMoment;
        this.diagnostic = diagnostic;
        this.symptoms = symptoms;
        this.type = type;
        this.patient_id = patient_id;
        this.professional_id = professional_id;
        this.prescription = prescription;
        this.hospitalization = hospitalization;
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

    public Modality getType() {
        return type;
    }

    public void setType(Modality type) {
        this.type = type;
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

    public CreateHospitalAdmissionRequest getHospitalization() {
        return hospitalization;
    }

    public void setHospitalization(CreateHospitalAdmissionRequest hospitalization) {
        this.hospitalization = hospitalization;
    }
}

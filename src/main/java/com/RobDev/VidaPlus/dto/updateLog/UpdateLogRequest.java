package com.RobDev.VidaPlus.dto.updateLog;

import com.RobDev.VidaPlus.dto.healthProfessional.HpResponse;
import com.RobDev.VidaPlus.dto.medicalRecord.MedicalRecordResponse;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.Size;

import java.time.LocalDateTime;

public class UpdateLogRequest {

    @Size(max = 300, message = "invalid diagnostic size")
    private String diagnostic;

    @Size(max = 350, message = "invalid observation size")
    private String patientObservation;

    @Size(max = 350, message = "invalid description size")
    private String updateDescription;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime updateDate;


    private long medicalRecordId;
    private long professionalId;

    public UpdateLogRequest() {

    }

    public UpdateLogRequest(String diagnostic, String patientObservation, String updateDescription, LocalDateTime updateDate, long medicalRecordId, long professionalId) {
        this.diagnostic = diagnostic;
        this.patientObservation = patientObservation;
        this.updateDescription = updateDescription;
        this.updateDate = updateDate;
        this.medicalRecordId = medicalRecordId;
        this.professionalId = professionalId;
    }

    public String getDiagnostic() {
        return diagnostic;
    }

    public void setDiagnostic(String diagnostic) {
        this.diagnostic = diagnostic;
    }

    public String getPatientObservation() {
        return patientObservation;
    }

    public void setPatientObservation(String patientObservation) {
        this.patientObservation = patientObservation;
    }

    public String getUpdateDescription() {
        return updateDescription;
    }

    public void setUpdateDescription(String updateDescription) {
        this.updateDescription = updateDescription;
    }

    public LocalDateTime getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(LocalDateTime updateDate) {
        this.updateDate = updateDate;
    }

    public long getMedicalRecordId() {
        return medicalRecordId;
    }

    public void setMedicalRecordId(long medicalRecordId) {
        this.medicalRecordId = medicalRecordId;
    }

    public long getProfessionalId() {
        return professionalId;
    }

    public void setProfessionalId(long professionalId) {
        this.professionalId = professionalId;
    }
}

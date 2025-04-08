package com.RobDev.VidaPlus.dto.medicalRecord;

import java.io.Serializable;
import java.sql.Timestamp;

public class CreateMedicalRecordRequest implements Serializable {

    private Timestamp dateRecord;
    private String diagnostic;
    private String patientObservation;
    private long patientId;
    private long professionalId;

    public CreateMedicalRecordRequest(){}

    public CreateMedicalRecordRequest(Timestamp dateRecord, String diagnostic, String patientObservation, long patientId, long professionalId) {
        this.dateRecord = dateRecord;
        this.diagnostic = diagnostic;
        this.patientObservation = patientObservation;
        this.patientId = patientId;
        this.professionalId = professionalId;
    }

    public Timestamp getDateRecord() {
        return dateRecord;
    }

    public void setDateRecord(Timestamp dateRecord) {
        this.dateRecord = dateRecord;
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

    public long getPatientId() {
        return patientId;
    }

    public void setPatientId(long patientId) {
        this.patientId = patientId;
    }

    public long getProfessionalId() {
        return professionalId;
    }

    public void setProfessionalId(long professionalId) {
        this.professionalId = professionalId;
    }
}

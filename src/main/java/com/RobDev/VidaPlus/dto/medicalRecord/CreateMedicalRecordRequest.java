package com.RobDev.VidaPlus.dto.medicalRecord;

import java.io.Serializable;

public class CreateMedicalRecordRequest implements Serializable {

    private String diagnostic;
    private String patientObservation;
    private long patientId;
    private long professionalId;

    public CreateMedicalRecordRequest(){}

    public CreateMedicalRecordRequest( String diagnostic, String patientObservation, long patientId, long professionalId) {

        this.diagnostic = diagnostic;
        this.patientObservation = patientObservation;
        this.patientId = patientId;
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

package com.RobDev.VidaPlus.dto.medicalRecord;


import jakarta.validation.constraints.Size;

public class UpdateMedicalRecordRequest {

    @Size(max = 300, message = "invalid diagnosis size")
    private String diagnostic;

    @Size(max = 350, message = "invalid observation size")
    private String patientObservation;

    public UpdateMedicalRecordRequest(){

    }

    public UpdateMedicalRecordRequest(String diagnostic, String patientObservation) {
        this.diagnostic = diagnostic;
        this.patientObservation = patientObservation;
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
}

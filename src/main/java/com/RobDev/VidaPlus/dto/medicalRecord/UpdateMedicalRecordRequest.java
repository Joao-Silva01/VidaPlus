package com.RobDev.VidaPlus.dto.medicalRecord;


public class UpdateMedicalRecordRequest {

    private String diagnostic;
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

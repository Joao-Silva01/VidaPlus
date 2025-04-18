package com.RobDev.VidaPlus.dto.medicalRecord;


import com.RobDev.VidaPlus.dto.healthProfessional.MinHpResponse;
import com.RobDev.VidaPlus.dto.patiente.PatientResponse;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;


public class MedicalRecordResponse {

    private long id;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "America/Sao_Paulo")
    private Timestamp dateRecord;
    private String diagnostic;
    private String patientObservation;
    private PatientResponse patient;

    private List<MinHpResponse> professionals = new ArrayList<>();

    public MedicalRecordResponse(){}

    public MedicalRecordResponse(long id, Timestamp dateRecord, String diagnostic, String patientObservation, PatientResponse patient) {
        this.id = id;
        this.dateRecord = dateRecord;
        this.diagnostic = diagnostic;
        this.patientObservation = patientObservation;
        this.patient = patient;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public PatientResponse getPatient() {
        return patient;
    }

    public void setPatient(PatientResponse patient) {
        this.patient = patient;
    }

    public List<MinHpResponse> getProfessionals() {
        return professionals;
    }

    public void setProfessionals(List<MinHpResponse> professionals) {
        this.professionals = professionals;
    }
}

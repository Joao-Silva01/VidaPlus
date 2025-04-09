package com.RobDev.VidaPlus.dto.medicalRecord;


import com.RobDev.VidaPlus.dto.healthProfessional.RecordProfessionalResponse;
import com.RobDev.VidaPlus.dto.patiente.PatientResponse;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;

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

    private List<RecordProfessionalResponse> professionals = new ArrayList<>();

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

    public List<RecordProfessionalResponse> getProfessionals() {
        return professionals;
    }

    public void setProfessionals(List<RecordProfessionalResponse> professionals) {
        this.professionals = professionals;
    }
}

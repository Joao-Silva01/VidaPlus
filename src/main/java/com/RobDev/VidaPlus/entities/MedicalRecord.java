package com.RobDev.VidaPlus.entities;

import jakarta.persistence.*;

import java.sql.Timestamp;
import java.util.Objects;

@Entity
public class MedicalRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private Timestamp dateRecord;
    private String diagnostic;
    private String patientObservation;

    @OneToOne
    @JoinColumn(name = "patient", unique = true)
    private Patient patient;

    public MedicalRecord(){}

    public MedicalRecord(long id, Timestamp dateRecord, String diagnostic, String patientObservation) {
        this.id = id;
        this.dateRecord = dateRecord;
        this.diagnostic = diagnostic;
        this.patientObservation = patientObservation;
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

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MedicalRecord that = (MedicalRecord) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}

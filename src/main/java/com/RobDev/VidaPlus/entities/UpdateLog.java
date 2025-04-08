package com.RobDev.VidaPlus.entities;

import jakarta.persistence.*;

import java.sql.Timestamp;
import java.util.Objects;

@Entity
public class UpdateLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String updateDescription;
    private Timestamp updateDate;

    @ManyToOne
    @JoinColumn(name = "medicalRecord")
    private MedicalRecord medicalRecord;

    @ManyToOne
    @JoinColumn(name = "professional")
    private HealthProfessional professional;

    public UpdateLog() {

    }

    public UpdateLog(long id, String updateDescription, Timestamp updateDate, MedicalRecord medicalRecord, HealthProfessional professional) {
        this.id = id;
        this.updateDescription = updateDescription;
        this.updateDate = updateDate;
        this.medicalRecord = medicalRecord;
        this.professional = professional;
    }

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public MedicalRecord getMedicalRecord() {
        return medicalRecord;
    }

    public void setMedicalRecord(MedicalRecord medicalRecord) {
        this.medicalRecord = medicalRecord;
    }

    public HealthProfessional getProfessional() {
        return professional;
    }

    public void setProfessional(HealthProfessional professional) {
        this.professional = professional;
    }

    public String getUpdateDescription() {
        return updateDescription;
    }

    public void setUpdateDescription(String updateDescription) {
        this.updateDescription = updateDescription;
    }

    public Timestamp getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Timestamp updateDate) {
        this.updateDate = updateDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UpdateLog updateLog = (UpdateLog) o;
        return id == updateLog.id;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}

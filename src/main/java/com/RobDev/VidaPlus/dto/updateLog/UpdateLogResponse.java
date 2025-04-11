package com.RobDev.VidaPlus.dto.updateLog;

import com.RobDev.VidaPlus.dto.healthProfessional.HpResponse;
import com.RobDev.VidaPlus.dto.medicalRecord.MedicalRecordResponse;
import com.RobDev.VidaPlus.entities.HealthProfessional;
import com.RobDev.VidaPlus.entities.MedicalRecord;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Size;

import java.sql.Timestamp;
import java.time.LocalDateTime;

public class UpdateLogResponse {

    private long id;


    private String updateDescription;

    @JsonFormat( pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime updateDate;
    private MedicalRecordResponse medicalRecord;
    private HpResponse professional;

    public UpdateLogResponse(){

    }

    public UpdateLogResponse(long id, String updateDescription, LocalDateTime updateDate, MedicalRecordResponse medicalRecord, HpResponse professional) {
        this.id = id;
        this.updateDescription = updateDescription;
        this.updateDate = updateDate;
        this.medicalRecord = medicalRecord;
        this.professional = professional;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public MedicalRecordResponse getMedicalRecord() {
        return medicalRecord;
    }

    public void setMedicalRecord(MedicalRecordResponse medicalRecord) {
        this.medicalRecord = medicalRecord;
    }

    public HpResponse getProfessional() {
        return professional;
    }

    public void setProfessional(HpResponse professional) {
        this.professional = professional;
    }
}

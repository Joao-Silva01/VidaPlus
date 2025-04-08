package com.RobDev.VidaPlus.entities;

import com.RobDev.VidaPlus.entities.compositePK.ProfessionalAndRecordPK;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;

import java.sql.Timestamp;

@Entity
public class UpdateLog {

    @EmbeddedId
    private ProfessionalAndRecordPK prId = new ProfessionalAndRecordPK();
    private String updateDescription;
    private Timestamp updateDate;

    public UpdateLog(){

    }

    public UpdateLog(HealthProfessional hp, MedicalRecord mr, String updateDescription, Timestamp updateDate) {
        prId.setProfessional(hp);
        prId.setMedicalRecord(mr);
        this.updateDescription = updateDescription;
        this.updateDate = updateDate;
    }

    public ProfessionalAndRecordPK getPrId() {
        return prId;
    }

    public void setPrId(ProfessionalAndRecordPK prId) {
        this.prId = prId;
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
}

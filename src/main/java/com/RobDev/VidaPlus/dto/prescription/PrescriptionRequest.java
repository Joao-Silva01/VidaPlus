package com.RobDev.VidaPlus.dto.prescription;

import com.RobDev.VidaPlus.entities.enums.Modality;
import com.RobDev.VidaPlus.entities.Prescription;
import org.springframework.beans.BeanUtils;

import java.sql.Timestamp;

public class PrescriptionRequest {

    private String description;
    private Timestamp prescriptionDate;
    private String digitalSignature;

    public PrescriptionRequest(){}

    public PrescriptionRequest(Prescription entity) {
        BeanUtils.copyProperties(entity, this);
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Timestamp getPrescriptionDate() {
        return prescriptionDate;
    }

    public void setPrescriptionDate(Timestamp prescriptionDate) {
        this.prescriptionDate = prescriptionDate;
    }

    public String getDigitalSignature() {
        return digitalSignature;
    }

    public void setDigitalSignature(String digitalSignature) {
        this.digitalSignature = digitalSignature;
    }
}

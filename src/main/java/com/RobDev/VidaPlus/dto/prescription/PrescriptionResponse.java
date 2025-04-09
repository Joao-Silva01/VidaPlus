package com.RobDev.VidaPlus.dto.prescription;

import com.RobDev.VidaPlus.entities.enums.Modality;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.sql.Timestamp;

public class PrescriptionResponse implements Serializable {

    private long id;
    private String description;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "America/Sao_Paulo")
    private Timestamp prescriptionDate;
    private Modality type;
    private String digitalSignature;

    public PrescriptionResponse() {
    }

    public PrescriptionResponse(long id, String description, Timestamp prescriptionDate, Modality type, String digitalSignature) {
        this.id = id;
        this.description = description;
        this.prescriptionDate = prescriptionDate;
        this.type = type;
        this.digitalSignature = digitalSignature;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public Modality getType() {
        return type;
    }

    public void setType(Modality type) {
        this.type = type;
    }

    public String getDigitalSignature() {
        return digitalSignature;
    }

    public void setDigitalSignature(String digitalSignature) {
        this.digitalSignature = digitalSignature;
    }
}

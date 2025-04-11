package com.RobDev.VidaPlus.dto.prescription;

import com.RobDev.VidaPlus.entities.enums.Modality;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.sql.Timestamp;
import java.time.LocalDateTime;

public class PrescriptionResponse implements Serializable {

    private long id;
    private String description;

    @JsonFormat( pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime prescriptionDate;
    private Modality type;
    private String signature;

    public PrescriptionResponse() {
    }

    public PrescriptionResponse(long id, String description, LocalDateTime prescriptionDate, Modality type, String signature) {
        this.id = id;
        this.description = description;
        this.prescriptionDate = prescriptionDate;
        this.type = type;
        this.signature = signature;
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

    public LocalDateTime getPrescriptionDate() {
        return prescriptionDate;
    }

    public void setPrescriptionDate(LocalDateTime prescriptionDate) {
        this.prescriptionDate = prescriptionDate;
    }

    public Modality getType() {
        return type;
    }

    public void setType(Modality type) {
        this.type = type;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }
}

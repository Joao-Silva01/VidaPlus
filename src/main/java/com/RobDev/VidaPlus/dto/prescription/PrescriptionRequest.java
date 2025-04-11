package com.RobDev.VidaPlus.dto.prescription;

import com.RobDev.VidaPlus.entities.enums.Modality;
import com.RobDev.VidaPlus.entities.Prescription;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.beans.BeanUtils;

import java.sql.Timestamp;
import java.time.LocalDateTime;

public class PrescriptionRequest {

    private String description;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime prescriptionDate;

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

    public LocalDateTime getPrescriptionDate() {
        return prescriptionDate;
    }

    public void setPrescriptionDate(LocalDateTime prescriptionDate) {
        this.prescriptionDate = prescriptionDate;
    }
}

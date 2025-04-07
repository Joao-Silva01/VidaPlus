package com.RobDev.VidaPlus.dto.prescription;

public class UpdatePrescriptionRequest {

    private String description;

    public UpdatePrescriptionRequest(){}

    public UpdatePrescriptionRequest(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

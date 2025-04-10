package com.RobDev.VidaPlus.dto.consultation;

import com.RobDev.VidaPlus.entities.enums.Status;
import jakarta.validation.constraints.Size;


public class UpdateConsultRequest {

    @Size(max = 200, message = "invalid diagnostic size")
    private String diagnostic;

    @Size(max = 200, message = "invalid symptoms size")
    private String symptoms;
    private Status status;

    public UpdateConsultRequest(String diagnostic, String symptoms, Status status) {

        this.diagnostic = diagnostic;
        this.symptoms = symptoms;
        this.status = status;
    }

    public String getDiagnostic() {
        return diagnostic;
    }

    public void setDiagnostic(String diagnostic) {
        this.diagnostic = diagnostic;
    }

    public String getSymptoms() {
        return symptoms;
    }

    public void setSymptoms(String symptoms) {
        this.symptoms = symptoms;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}

package com.RobDev.VidaPlus.dto.report;

import com.RobDev.VidaPlus.entities.Report;
import org.hibernate.validator.constraints.Length;

public class ReportRequest {

    @Length(max = 350)
    private String observation;

    public ReportRequest() {

    }

    public ReportRequest(String observation) {
        this.observation = observation;
    }

    public String getObservation() {
        return observation;
    }

    public void setObservation(String observation) {
        this.observation = observation;
    }
}

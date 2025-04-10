package com.RobDev.VidaPlus.dto.hospitalAdmission;


import com.RobDev.VidaPlus.entities.enums.Situation;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.Size;

import java.sql.Timestamp;

public class UpdateHospitalAdmissionRequest {

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm", timezone = "America/Sao_Paulo")
    private Timestamp dischargeDate;

    @Size(max = 200, message = "invalid reason size")
    private String reason;
    private int patientRoom;
    private Situation situation;

    @Size(max = 350, message = "invalid observation size")
    private String observation;

    public UpdateHospitalAdmissionRequest(){

    }

    public UpdateHospitalAdmissionRequest(Timestamp dischargeDate, String reason, int patientRoom, Situation situation, String observation) {
        this.dischargeDate = dischargeDate;
        this.reason = reason;
        this.patientRoom = patientRoom;
        this.situation = situation;
        this.observation = observation;
    }

    public Timestamp getDischargeDate() {
        return dischargeDate;
    }

    public void setDischargeDate(Timestamp dischargeDate) {
        this.dischargeDate = dischargeDate;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public int getPatientRoom() {
        return patientRoom;
    }

    public void setPatientRoom(int patientRoom) {
        this.patientRoom = patientRoom;
    }

    public Situation getSituation() {
        return situation;
    }

    public void setSituation(Situation situation) {
        this.situation = situation;
    }

    public String getObservation() {
        return observation;
    }

    public void setObservation(String observation) {
        this.observation = observation;
    }
}

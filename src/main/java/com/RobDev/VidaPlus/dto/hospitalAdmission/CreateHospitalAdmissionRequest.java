package com.RobDev.VidaPlus.dto.hospitalAdmission;

import com.RobDev.VidaPlus.entities.enums.Situation;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.Size;

import java.io.Serializable;
import java.sql.Timestamp;
import java.time.LocalDateTime;


public class CreateHospitalAdmissionRequest implements Serializable {

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime hospitalizationDate;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime dischargeDate;

    @Size(max = 200, message = "invalid reason size")
    private String reason;
    private int patientRoom;
    private Situation situation;

    @Size(max = 350, message = "invalid observation size")
    private String observation;

    public CreateHospitalAdmissionRequest() {
    }

    public CreateHospitalAdmissionRequest(LocalDateTime hospitalizationDate, LocalDateTime dischargeDate, String reason, int patientRoom, Situation situation, String observation) {
        this.hospitalizationDate = hospitalizationDate;
        this.dischargeDate = dischargeDate;
        this.reason = reason;
        this.patientRoom = patientRoom;
        this.situation = situation;
        this.observation = observation;
    }

    public LocalDateTime getHospitalizationDate() {
        return hospitalizationDate;
    }

    public void setHospitalizationDate(LocalDateTime hospitalizationDate) {
        this.hospitalizationDate = hospitalizationDate;
    }

    public LocalDateTime getDischargeDate() {
        return dischargeDate;
    }

    public void setDischargeDate(LocalDateTime dischargeDate) {
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

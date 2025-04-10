package com.RobDev.VidaPlus.dto.hospitalAdmission;

import com.RobDev.VidaPlus.entities.enums.Situation;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.sql.Timestamp;
import java.time.LocalDateTime;

public class HospitalAdmissionResponse {

    private long id;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime hospitalizationDate;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime dischargeDate;
    private String reason;
    private int patientRoom;
    private Situation situation;
    private String observation;

    public HospitalAdmissionResponse() {
    }


    public HospitalAdmissionResponse(long id, LocalDateTime hospitalizationDate, LocalDateTime dischargeDate, String reason, int patientRoom, Situation situation, String observation) {
        this.id = id;
        this.hospitalizationDate = hospitalizationDate;
        this.dischargeDate = dischargeDate;
        this.reason = reason;
        this.patientRoom = patientRoom;
        this.situation = situation;
        this.observation = observation;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

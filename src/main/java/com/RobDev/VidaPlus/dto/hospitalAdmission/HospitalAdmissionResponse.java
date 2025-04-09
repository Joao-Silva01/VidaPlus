package com.RobDev.VidaPlus.dto.hospitalAdmission;

import com.RobDev.VidaPlus.entities.enums.Situation;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.sql.Timestamp;

public class HospitalAdmissionResponse {

    private long id;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "America/Sao_Paulo")
    private Timestamp hospitalizationDate;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "America/Sao_Paulo")
    private Timestamp dischargeDate;
    private String reason;
    private int patientRoom;
    private Situation situation;
    private String observation;

    public HospitalAdmissionResponse() {
    }


    public HospitalAdmissionResponse(long id, Timestamp hospitalizationDate, Timestamp dischargeDate, String reason, int patientRoom, Situation situation, String observation) {
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

    public Timestamp getHospitalizationDate() {
        return hospitalizationDate;
    }

    public void setHospitalizationDate(Timestamp hospitalizationDate) {
        this.hospitalizationDate = hospitalizationDate;
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

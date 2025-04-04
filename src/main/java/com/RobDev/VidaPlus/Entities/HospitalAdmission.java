package com.RobDev.VidaPlus.Entities;

import com.RobDev.VidaPlus.Entities.Enums.Situation;
import jakarta.persistence.*;

import java.sql.Timestamp;
import java.util.Objects;

@Entity
public class HospitalAdmission {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private Timestamp hospitalizationDate;
    private Timestamp dischargeDate;
    private String reason;
    private int patientRoom;

    @Enumerated(value = EnumType.STRING)
    private Situation situation;
    private String observation;

    public HospitalAdmission(){}

    public HospitalAdmission(long id, Timestamp hospitalizationDate, Timestamp dischargeDate, String reason,
                             int patientRoom, Situation situation, String observation) {

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HospitalAdmission that = (HospitalAdmission) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}

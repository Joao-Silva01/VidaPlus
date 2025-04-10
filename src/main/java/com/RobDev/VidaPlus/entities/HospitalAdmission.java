package com.RobDev.VidaPlus.entities;

import com.RobDev.VidaPlus.entities.enums.Situation;
import jakarta.persistence.*;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
public class HospitalAdmission {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private LocalDateTime hospitalizationDate;
    private LocalDateTime dischargeDate;
    private String reason;
    private int patientRoom;

    @Enumerated(value = EnumType.STRING)
    private Situation situation;
    private String observation;

    @OneToOne
    @JoinColumn(name = "consultation", unique = true)
    private Consultation consultation;

    public HospitalAdmission(){}

    public HospitalAdmission(long id, LocalDateTime hospitalizationDate, LocalDateTime dischargeDate, String reason,
                             int patientRoom, Situation situation, String observation, Consultation consultation) {
        this.id = id;
        this.hospitalizationDate = hospitalizationDate;
        this.dischargeDate = dischargeDate;
        this.reason = reason;
        this.patientRoom = patientRoom;
        this.situation = situation;
        this.observation = observation;
        this.consultation = consultation;
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

    public Consultation getConsultation() {
        return consultation;
    }

    public void setConsultation(Consultation consultation) {
        this.consultation = consultation;
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

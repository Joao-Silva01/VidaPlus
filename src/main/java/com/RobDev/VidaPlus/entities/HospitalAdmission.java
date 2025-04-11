package com.RobDev.VidaPlus.entities;

import com.RobDev.VidaPlus.entities.enums.Situation;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Objects;

@Entity
public class HospitalAdmission {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private LocalDateTime hospitalizationDate;
    private LocalDateTime dischargeDate;

    @Column(scale = 10, precision = 2)
    private BigDecimal dailyCost;
    private String reason;
    private int patientRoom;

    @Enumerated(value = EnumType.STRING)
    private Situation situation;
    private String observation;

    @OneToOne
    @JoinColumn(name = "consultation", unique = true)
    private Consultation consultation;

    public HospitalAdmission(){}

    public HospitalAdmission(long id, LocalDateTime hospitalizationDate, LocalDateTime dischargeDate,
                             BigDecimal dailyCost, String reason, int patientRoom,
                             Situation situation, String observation, Consultation consultation) {
        this.id = id;
        this.hospitalizationDate = hospitalizationDate;
        this.dischargeDate = dischargeDate;
        this.reason = reason;
        this.patientRoom = patientRoom;
        this.situation = situation;
        this.observation = observation;
        this.consultation = consultation;
        this.dailyCost = dailyCost;
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

    public BigDecimal getDailyCost() {
        return dailyCost;
    }

    public void setDailyCost(BigDecimal dailyCost) {
        this.dailyCost = dailyCost;
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

    public BigDecimal totalValueHospitalization(){

        // Verifica se a data da alta do paciente não é null
        if (dischargeDate == null){
            throw new RuntimeException("NULOOOOOO");
        }

        Long totalDays = null;

        // adiciona mais 1 dia caso a data da alta do paciente passe de 12 horas
        if(dischargeDate.getHour() > 12){
            totalDays = ChronoUnit.DAYS.between(hospitalizationDate, dischargeDate.plusDays(1));
        }else {
            totalDays = ChronoUnit.DAYS.between(hospitalizationDate, dischargeDate);
        }

        //Realiza o calculo total do custo da hospitalização
        BigDecimal calculation = dailyCost.multiply(BigDecimal.valueOf(totalDays));

        return calculation;

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

package com.RobDev.VidaPlus.entities;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
public class Report {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private LocalDateTime generationDate;
    private long numberQueries;
    private long numberHospitalization;
    private long numberExams;
    private long numberPrescriptions;
    private String observation;

    @Column(scale = 100, precision = 2)
    private BigDecimal invoicing;

    @ManyToOne
    @JoinColumn(name = "admin")
    private Administrator admin;

    public Report() {
    }

    public Report(long id, LocalDateTime generationDate, long numberQueries,
                  long numberHospitalization, long numberExams,
                  long numberPrescriptions, String observation,
                  BigDecimal invoicing, Administrator admin) {
        this.id = id;
        this.generationDate = generationDate;
        this.numberQueries = numberQueries;
        this.numberHospitalization = numberHospitalization;
        this.numberExams = numberExams;
        this.numberPrescriptions = numberPrescriptions;
        this.observation = observation;
        this.invoicing = invoicing;
        this.admin = admin;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalDateTime getGenerationDate() {
        return generationDate;
    }

    public void setGenerationDate(LocalDateTime generationDate) {
        this.generationDate = generationDate;
    }

    public long getNumberQueries() {
        return numberQueries;
    }

    public void setNumberQueries(long numberQueries) {
        this.numberQueries = numberQueries;
    }

    public long getNumberHospitalization() {
        return numberHospitalization;
    }

    public void setNumberHospitalization(long numberHospitalization) {
        this.numberHospitalization = numberHospitalization;
    }

    public long getNumberExams() {
        return numberExams;
    }

    public void setNumberExams(long numberExams) {
        this.numberExams = numberExams;
    }

    public long getNumberPrescriptions() {
        return numberPrescriptions;
    }

    public void setNumberPrescriptions(long numberPrescriptions) {
        this.numberPrescriptions = numberPrescriptions;
    }

    public String getObservation() {
        return observation;
    }

    public void setObservation(String observation) {
        this.observation = observation;
    }

    public BigDecimal getInvoicing() {
        return invoicing;
    }

    public void setInvoicing(BigDecimal invoicing) {
        this.invoicing = invoicing;
    }

    public Administrator getAdmin() {
        return admin;
    }

    public void setAdmin(Administrator admin) {
        this.admin = admin;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Report report = (Report) o;
        return id == report.id;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}

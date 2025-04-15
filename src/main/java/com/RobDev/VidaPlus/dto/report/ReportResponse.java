package com.RobDev.VidaPlus.dto.report;

import com.RobDev.VidaPlus.dto.administrator.AdminResponse;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import org.hibernate.validator.constraints.Length;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class ReportResponse {

    private long id;

    @JsonFormat( pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime generationDate;
    private long numberQueries;
    private long numberHospitalization;
    private long numberExams;
    private long numberPrescriptions;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Length(max = 350)
    private String observation;
    private BigDecimal invoicing;
    private AdminResponse admin;

    public ReportResponse(){

    }

    public ReportResponse(long id, LocalDateTime generationDate, long numberQueries, long numberHospitalization, long numberExams, long numberPrescriptions, String observation, BigDecimal invoicing, AdminResponse admin) {
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

    public AdminResponse getAdmin() {
        return admin;
    }

    public void setAdmin(AdminResponse admin) {
        this.admin = admin;
    }
}

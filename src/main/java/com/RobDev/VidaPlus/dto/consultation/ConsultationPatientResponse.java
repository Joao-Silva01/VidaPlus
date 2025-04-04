package com.RobDev.VidaPlus.dto.consultation;

import com.RobDev.VidaPlus.Entities.Enums.Modality;
import com.RobDev.VidaPlus.Entities.Enums.Status;
import com.RobDev.VidaPlus.dto.healthprofessional.HpResponse;
import com.RobDev.VidaPlus.dto.hospitalAdmission.HospitalAdmissionResponse;
import com.RobDev.VidaPlus.dto.medicalExamination.ExamResponse;
import com.RobDev.VidaPlus.dto.prescription.PrescriptionResponse;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ConsultationPatientResponse {
    private long id;
    private Date consultationMoment;
    private String diagnostic;
    private String symptoms;
    private BigDecimal ConsultationFee;
    private String consultationLink;
    private Modality type;
    private Status status;
    private HpResponse professional;
    private PrescriptionResponse prescription;
    private List<ExamResponse> requestedExams = new ArrayList<>();
    private HospitalAdmissionResponse hospitalization;

    public ConsultationPatientResponse(long id, Date consultationMoment, String diagnostic, String symptoms,
                                       BigDecimal consultationFee, String consultationLink, Modality type,
                                       Status status, HpResponse professional, PrescriptionResponse prescription,
                                       HospitalAdmissionResponse hospitalization) {
        this.id = id;
        this.consultationMoment = consultationMoment;
        this.diagnostic = diagnostic;
        this.symptoms = symptoms;
        ConsultationFee = consultationFee;
        this.consultationLink = consultationLink;
        this.type = type;
        this.status = status;
        this.professional = professional;
        this.prescription = prescription;
        this.hospitalization = hospitalization;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getConsultationMoment() {
        return consultationMoment;
    }

    public void setConsultationMoment(Date consultationMoment) {
        this.consultationMoment = consultationMoment;
    }

    public String getDiagnostic() {
        return diagnostic;
    }

    public void setDiagnostic(String diagnostic) {
        this.diagnostic = diagnostic;
    }

    public String getSymptoms() {
        return symptoms;
    }

    public void setSymptoms(String symptoms) {
        this.symptoms = symptoms;
    }

    public BigDecimal getConsultationFee() {
        return ConsultationFee;
    }

    public void setConsultationFee(BigDecimal consultationFee) {
        ConsultationFee = consultationFee;
    }

    public String getConsultationLink() {
        return consultationLink;
    }

    public void setConsultationLink(String consultationLink) {
        this.consultationLink = consultationLink;
    }

    public Modality getType() {
        return type;
    }

    public void setType(Modality type) {
        this.type = type;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public HpResponse getProfessional() {
        return professional;
    }

    public void setProfessional(HpResponse professional) {
        this.professional = professional;
    }

    public PrescriptionResponse getPrescription() {
        return prescription;
    }

    public void setPrescription(PrescriptionResponse prescription) {
        this.prescription = prescription;
    }

    public List<ExamResponse> getRequestedExams() {
        return requestedExams;
    }

    public void setRequestedExams(List<ExamResponse> requestedExams) {
        this.requestedExams = requestedExams;
    }

    public HospitalAdmissionResponse getHospitalization() {
        return hospitalization;
    }

    public void setHospitalization(HospitalAdmissionResponse hospitalization) {
        this.hospitalization = hospitalization;
    }
}

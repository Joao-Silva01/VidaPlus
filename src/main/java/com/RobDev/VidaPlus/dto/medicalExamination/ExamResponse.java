package com.RobDev.VidaPlus.dto.medicalExamination;

import com.RobDev.VidaPlus.entities.enums.Exam;
import com.RobDev.VidaPlus.entities.enums.Status;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.LocalDateTime;

public class ExamResponse {

    private long id;
    private String description;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime examDate;
    private BigDecimal examFee;
    private Exam type;
    private Status status;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String result;

    public ExamResponse() {
    }

    public ExamResponse(long id, String description, LocalDateTime examDate, BigDecimal examFee,
                        Exam type, Status status, String result) {
        this.id = id;
        this.description = description;
        this.examDate = examDate;
        this.type = type;
        this.status = status;
        this.result = result;
        this.examFee = examFee;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getExamDate() {
        return examDate;
    }

    public void setExamDate(LocalDateTime examDate) {
        this.examDate = examDate;
    }

    public BigDecimal getExamFee() {
        return examFee;
    }

    public void setExamFee(BigDecimal examFee) {
        this.examFee = examFee;
    }

    public Exam getType() {
        return type;
    }

    public void setType(Exam type) {
        this.type = type;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}

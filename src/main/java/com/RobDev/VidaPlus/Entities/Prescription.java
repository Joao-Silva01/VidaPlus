package com.RobDev.VidaPlus.Entities;

import com.RobDev.VidaPlus.Entities.Enums.Modality;
import jakarta.persistence.*;

import java.sql.Timestamp;
import java.util.Objects;

@Entity
public class Prescription {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, length = 350)
    private String description;

    @Column(nullable = false)
    private Timestamp prescriptionDate;

    @Column(nullable = false, length = 9)
    @Enumerated(value = EnumType.STRING)
    private Modality type;

    @Column(nullable = false, length = 100)
    private String digitalSignature;

    @OneToOne
    @JoinColumn(name = "consultation", unique = true)
    private Consultation consultation;

    public Prescription(){

    }

    public Prescription(long id, String description, Timestamp prescriptionDate, Modality type, String digitalSignature,
                        Consultation consultation) {
        this.id = id;
        this.description = description;
        this.prescriptionDate = prescriptionDate;
        this.type = type;
        this.digitalSignature = digitalSignature;
        this.consultation = consultation;
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

    public Timestamp getPrescriptionDate() {
        return prescriptionDate;
    }

    public void setPrescriptionDate(Timestamp prescriptionDate) {
        this.prescriptionDate = prescriptionDate;
    }

    public Modality getType() {
        return type;
    }

    public void setType(Modality type) {
        this.type = type;
    }

    public String getDigitalSignature() {
        return digitalSignature;
    }

    public void setDigitalSignature(String digitalSignature) {
        this.digitalSignature = digitalSignature;
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
        Prescription that = (Prescription) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}

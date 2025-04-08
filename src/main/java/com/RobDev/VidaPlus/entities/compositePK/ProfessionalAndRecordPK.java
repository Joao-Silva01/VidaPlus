package com.RobDev.VidaPlus.entities.compositePK;

import com.RobDev.VidaPlus.entities.HealthProfessional;
import com.RobDev.VidaPlus.entities.MedicalRecord;
import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.util.Objects;

@Embeddable
public class ProfessionalAndRecordPK {

    @ManyToOne
    @JoinColumn(name = "medicalRecord")
    private MedicalRecord medicalRecord;

    @ManyToOne
    @JoinColumn(name = "professional")
    private HealthProfessional professional;

    public HealthProfessional getProfessional() {
        return professional;
    }

    public void setProfessional(HealthProfessional professional) {
        this.professional = professional;
    }

    public MedicalRecord getMedicalRecord() {
        return medicalRecord;
    }

    public void setMedicalRecord(MedicalRecord medicalRecord) {
        this.medicalRecord = medicalRecord;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProfessionalAndRecordPK that = (ProfessionalAndRecordPK) o;
        return Objects.equals(medicalRecord, that.medicalRecord) && Objects.equals(professional, that.professional);
    }

    @Override
    public int hashCode() {
        return Objects.hash(medicalRecord, professional);
    }
}

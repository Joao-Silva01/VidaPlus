package com.RobDev.VidaPlus.repositories;


import com.RobDev.VidaPlus.entities.MedicalExamination;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;

@Repository
public interface MedicalExaminationRepository extends JpaRepository<MedicalExamination, Long> {

    @Query(value = "SELECT COUNT(*) FROM MEDICAL_EXAMINATION", nativeQuery = true)
    long allExams();

    @Query(value = "SELECT COALESCE(SUM(ME.EXAM_FEE),0) FROM MEDICAL_EXAMINATION as ME",nativeQuery = true)
    BigDecimal totalValue();
}

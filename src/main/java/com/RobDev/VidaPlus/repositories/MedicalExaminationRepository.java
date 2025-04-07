package com.RobDev.VidaPlus.repositories;


import com.RobDev.VidaPlus.entities.MedicalExamination;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicalExaminationRepository extends JpaRepository<MedicalExamination, Long> {
}

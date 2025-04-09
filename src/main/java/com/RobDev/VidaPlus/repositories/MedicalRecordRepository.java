package com.RobDev.VidaPlus.repositories;

import com.RobDev.VidaPlus.entities.MedicalRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MedicalRecordRepository extends JpaRepository<MedicalRecord, Long> {

    @Query(value = "SELECT * FROM MEDICAL_RECORD AS MR " +
            "WHERE MR.id = ?", nativeQuery = true)
    Optional<MedicalRecord> findByPatient(long patientId);
}

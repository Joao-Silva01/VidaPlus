package com.RobDev.VidaPlus.repositories;


import com.RobDev.VidaPlus.entities.HospitalAdmission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;

@Repository
public interface HospitalAdmissionRepository extends JpaRepository<HospitalAdmission, Long> {

    @Query(value = "SELECT COUNT(*) FROM HOSPITAL_ADMISSION", nativeQuery = true)
    long allHospitalizations();

    @Query(value = "SELECT SUM(HA.TOTAL_COST) FROM HOSPITAL_ADMISSION AS HA;", nativeQuery = true)
    BigDecimal totalValue();
}

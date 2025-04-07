package com.RobDev.VidaPlus.repositories;


import com.RobDev.VidaPlus.entities.HospitalAdmission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HospitalAdmissionRepository extends JpaRepository<HospitalAdmission, Long> {
}

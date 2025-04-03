package com.RobDev.VidaPlus.Repositories;


import com.RobDev.VidaPlus.Entities.Prescription;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PrescriptionRepository extends JpaRepository<Prescription, Long> {
}

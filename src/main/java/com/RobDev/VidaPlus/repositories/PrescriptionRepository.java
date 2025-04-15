package com.RobDev.VidaPlus.repositories;


import com.RobDev.VidaPlus.entities.Prescription;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PrescriptionRepository extends JpaRepository<Prescription, Long> {

    @Query(value = "SELECT COUNT(*) FROM PRESCRIPTION", nativeQuery = true)
    long allPrescriptions();
}

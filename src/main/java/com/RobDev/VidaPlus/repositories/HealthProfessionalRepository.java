package com.RobDev.VidaPlus.repositories;

import com.RobDev.VidaPlus.entities.HealthProfessional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface HealthProfessionalRepository extends JpaRepository<HealthProfessional, Long> {

    Optional<HealthProfessional> findByEmail(String email);
}

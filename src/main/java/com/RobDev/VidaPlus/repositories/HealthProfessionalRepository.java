package com.RobDev.VidaPlus.repositories;

import com.RobDev.VidaPlus.entities.HealthProfessional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HealthProfessionalRepository extends JpaRepository<HealthProfessional, Long> {
}

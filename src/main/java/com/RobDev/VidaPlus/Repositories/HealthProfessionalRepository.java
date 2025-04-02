package com.RobDev.VidaPlus.Repositories;

import com.RobDev.VidaPlus.Entities.HealthProfessional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HealthProfessionalRepository extends JpaRepository<HealthProfessional, Long> {
}

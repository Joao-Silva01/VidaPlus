package com.RobDev.VidaPlus.Repositories;

import com.RobDev.VidaPlus.Entities.Consultation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConsultationRepository extends JpaRepository<Consultation, Long> {
}

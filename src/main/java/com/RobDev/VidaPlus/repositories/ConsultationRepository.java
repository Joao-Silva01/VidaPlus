package com.RobDev.VidaPlus.repositories;

import com.RobDev.VidaPlus.entities.Consultation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;

@Repository
public interface ConsultationRepository extends JpaRepository<Consultation, Long> {

    @Query(value = "SELECT COUNT(*) FROM CONSULTATION", nativeQuery = true)
    long allQueries();

    @Query(value = "SELECT COALESCE(SUM(CO.CONSULTATION_FEE),0) FROM CONSULTATION AS CO",nativeQuery = true)
    BigDecimal totalValue();
}

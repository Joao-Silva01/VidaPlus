package com.RobDev.VidaPlus.repositories;

import com.RobDev.VidaPlus.entities.Agenda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AgendaRepository extends JpaRepository<Agenda, Long> {
}

package com.RobDev.VidaPlus.repositories;

import com.RobDev.VidaPlus.entities.UpdateLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UpdateLogRepository extends JpaRepository<UpdateLog, Long> {
}

package com.RobDev.VidaPlus.repositories;

import com.RobDev.VidaPlus.entities.Administrator;
import com.RobDev.VidaPlus.entities.HealthProfessional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AdministratorRepository extends JpaRepository<Administrator, Long> {

    Optional<Administrator> findByEmail(String email);
}

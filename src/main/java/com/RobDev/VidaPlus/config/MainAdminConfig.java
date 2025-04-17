package com.RobDev.VidaPlus.config;

import com.RobDev.VidaPlus.entities.Administrator;
import com.RobDev.VidaPlus.entities.HealthProfessional;
import com.RobDev.VidaPlus.entities.Patient;
import com.RobDev.VidaPlus.entities.enums.HealthProfession;
import com.RobDev.VidaPlus.entities.enums.Sex;
import com.RobDev.VidaPlus.entities.enums.UserRole;
import com.RobDev.VidaPlus.repositories.AdministratorRepository;
import com.RobDev.VidaPlus.repositories.HealthProfessionalRepository;
import com.RobDev.VidaPlus.repositories.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Configuration
public class MainAdminConfig implements CommandLineRunner {

    @Autowired
    private AdministratorRepository adminRepository;

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private HealthProfessionalRepository healthProfessionalRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public void run(String... args) throws Exception {

        if (!adminRepository.existsById(1L)) {
            Administrator main_admin = new Administrator();

            main_admin.setName("MAIN_ADMIN");
            main_admin.setEmail("jnete2004@gmail.com");
            main_admin.setPassword(bCryptPasswordEncoder.encode("main_admin_password"));
            main_admin.setRole(UserRole.MAIN_ADMIN);

            adminRepository.save(main_admin);
        }

        Patient patient = new Patient();

        if (!patientRepository.existsById(1L)) {
            patient.setName("João Silva");
            patient.setBirth_date(LocalDate.of(1990, 5, 20));
            patient.setPhone("1199999999");
            patient.setPassword(bCryptPasswordEncoder.encode("senhaSegura123"));
            patient.setSex(Sex.MALE);
            patient.setEmail("joao.silva@gmail.com");
            patient.setDocument("12345678901");
            patient.setRole(UserRole.PATIENT);
            patient.setRegisterMoment(LocalDateTime.now());

            patientRepository.save(patient);
        }

        HealthProfessional professional = new HealthProfessional();

        if(!healthProfessionalRepository.existsById(1L)) {
            professional.setName("Dra. Maria Oliveira");
            professional.setEmail("maria.oliveira@gmail.com");
            professional.setPhone("11988888888");
            professional.setPassword(bCryptPasswordEncoder.encode("senhaForte456"));
            professional.setDocument("10987654321");
            professional.setProfession(HealthProfession.DOCTOR);
            professional.setSpecialty("Cardiologia");
            professional.setRole(UserRole.PROFESSIONAL);
            professional.setRegisterMoment(Timestamp.from(Instant.now()));
            professional.setSignature("Dra. Maria Oliveira");

            healthProfessionalRepository.save(professional);
        }
    }
}

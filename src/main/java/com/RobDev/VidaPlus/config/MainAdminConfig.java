package com.RobDev.VidaPlus.config;

import com.RobDev.VidaPlus.entities.*;
import com.RobDev.VidaPlus.entities.enums.*;
import com.RobDev.VidaPlus.repositories.AdministratorRepository;
import com.RobDev.VidaPlus.repositories.ConsultationRepository;
import com.RobDev.VidaPlus.repositories.HealthProfessionalRepository;
import com.RobDev.VidaPlus.repositories.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Configuration
public class MainAdminConfig implements CommandLineRunner {

    @Autowired
    private AdministratorRepository adminRepository;

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private HealthProfessionalRepository healthProfessionalRepository;

    @Autowired
    private ConsultationRepository consultationRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public void run(String... args) throws Exception {


        // Creating Main_admin
        if (!adminRepository.existsById(1L)) {
            Administrator main_admin = new Administrator();

            main_admin.setName("MAIN_ADMIN");
            main_admin.setEmail("main@gmail.com");
            main_admin.setPassword(bCryptPasswordEncoder.encode("main_admin_password"));
            main_admin.setRole(UserRole.MAIN_ADMIN);

            adminRepository.save(main_admin);
        }

        if (!adminRepository.existsById(2L)) {
            Administrator main_admin = new Administrator();

            main_admin.setName("ADMIN");
            main_admin.setEmail("admin@gmail.com");
            main_admin.setPassword(bCryptPasswordEncoder.encode("admin_password"));
            main_admin.setRole(UserRole.ADMIN);

            adminRepository.save(main_admin);
        }


        // Creating patients
        Patient patient1 = new Patient();

        if (!patientRepository.existsById(1L)) {
            patient1.setName("João Silva");
            patient1.setBirth_date(LocalDate.of(1990, 5, 20));
            patient1.setPhone("1199999999");
            patient1.setPassword(bCryptPasswordEncoder.encode("_joao"));
            patient1.setSex(Sex.MALE);
            patient1.setEmail("jnete2003@gmail.com");
            patient1.setDocument("12345678901");
            patient1.setRole(UserRole.PATIENT);
            patient1.setRegisterMoment(LocalDateTime.now());

            patientRepository.save(patient1);
        }

        Patient patient2 = new Patient();

        if (!patientRepository.existsById(2L)) {
            patient2.setName("Maria Fonseca");
            patient2.setBirth_date(LocalDate.of(2004, 1, 14));
            patient2.setPhone("9846781234");
            patient2.setPassword(bCryptPasswordEncoder.encode("1990_fonseca"));
            patient2.setSex(Sex.FEMALE);
            patient2.setEmail("fonseca@gmail.com");
            patient2.setDocument("43775943030");
            patient2.setRole(UserRole.PATIENT);
            patient2.setRegisterMoment(LocalDateTime.now());

            patientRepository.save(patient2);
        }

        // Creating professional

        HealthProfessional professional = new HealthProfessional();

        if (!healthProfessionalRepository.existsById(1L)) {
            professional.setName("Dra. Maria Oliveira");
            professional.setEmail("maria.oliveira@gmail.com");
            professional.setPhone("11988888888");
            professional.setPassword(bCryptPasswordEncoder.encode("senhaForte456"));
            professional.setDocument("10987654321");
            professional.setProfession(HealthProfession.CARDIOLOGIST);
            professional.setSpecialty("Cardiologia");
            professional.setRole(UserRole.PROFESSIONAL);
            professional.setRegisterMoment(Timestamp.from(Instant.now()));
            professional.setSignature("Dra. Maria Oliveira");

            healthProfessionalRepository.save(professional);
        }

        // Creating Consultation
        if (patientRepository.existsById(1L) || healthProfessionalRepository.existsById(1L)) {

            if (!consultationRepository.existsById(1L)) {
                Consultation consultation = new Consultation();
                consultation.setConsultationMoment(LocalDateTime.now());
                consultation.setDiagnostic("Infecção bacteriana");
                consultation.setSymptoms("Febre, dor de cabeça e fadiga");
                consultation.setConsultationFee(BigDecimal.valueOf(245.00));
                consultation.setType(Modality.IN_PERSON);
                consultation.setStatus(Status.SCHEDULED);

                consultation.setPatient(patient1);
                consultation.setProfessional(professional);

                Prescription prescription = new Prescription();
                prescription.setDescription("Uso de antibiótico por 7 dias");
                prescription.setPrescriptionDate(LocalDateTime.now());
                prescription.setType(consultation.getType());
                prescription.setSignature(professional.getSignature());

                prescription.setConsultation(consultation);
                consultation.setPrescription(prescription);


                MedicalExamination exam = new MedicalExamination();
                exam.setDescription("Exame de sangue completo");
                exam.setExamDate(LocalDateTime.of(2025, 6, 20, 14, 30));
                exam.setType(Exam.LABORATORY);
                exam.setExamFee(BigDecimal.valueOf(55.65));
                exam.setStatus(Status.SCHEDULED);

                exam.setConsultation(consultation);
                consultation.setRequestedExams(List.of(exam));

                consultationRepository.save(consultation);
            }
        }
    }
}

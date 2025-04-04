package com.RobDev.VidaPlus.services;

import com.RobDev.VidaPlus.Entities.*;
import com.RobDev.VidaPlus.Repositories.ConsultationRepository;
import com.RobDev.VidaPlus.Repositories.HealthProfessionalRepository;
import com.RobDev.VidaPlus.Repositories.PatientRepository;
import com.RobDev.VidaPlus.dto.consultation.ConsultResponse;
import com.RobDev.VidaPlus.dto.consultation.CreateConsultRequest;
import com.RobDev.VidaPlus.dto.patiente.AllConsultationsPatientResponse;
import com.RobDev.VidaPlus.mapper.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConsultationService {

    @Autowired
    private ConsultationRepository consultationRepository;

    @Autowired
    private HealthProfessionalRepository hpRepository;

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private ConsultationMapper consultMapper;

    @Autowired
    private PrescriptionMapper prescriptionMapper;

    @Autowired
    private MedicalExaminationMapper examMapper;

    @Autowired
    private HospitalAdmissionMapper admissionMapper;

    @Autowired
    private PatientMapper patientMapper;

    public AllConsultationsPatientResponse getAllMedicalAppointmentsPatient(long patient_id){
        var patient = patientRepository.findById(patient_id).orElseThrow();

        return patientMapper.toAllConsultationsResponse(patient);
    }

    public ConsultResponse getConsult(long consult_id){
        Consultation consult = consultationRepository.findById(consult_id).orElseThrow();

        return consultMapper.toResponse(consult);
    }

    public ConsultResponse createConsult(long professional_id, CreateConsultRequest request) {
        HealthProfessional professional = hpRepository.findById(professional_id).orElseThrow();
        Patient patient = patientRepository.findById(request.getPatient_id()).orElseThrow();

        Consultation newConsult = consultMapper.toCreateConsult(request);
        newConsult.setPatient(patient);
        newConsult.setProfessional(professional);

        // Realiza o relacionamento entre HospitalAdmission e Consultation
        HospitalAdmission admission = admissionMapper.toCreateEntity(request.getHospitalization());
        if(admission != null){
            newConsult.setHospitalization(admission);
            admission.setConsultation(newConsult);
        }

        // Realiza o relacionamento entre MedicalExamination e Consultation
        List<MedicalExamination> exams = examMapper.toCreateListRequest(request.getRequestedExams());
        if(exams != null){
            newConsult.setRequestedExams(exams);
            for(MedicalExamination exam : exams){
                exam.setConsultation(newConsult);
            }
        }

        // Realiza o relacionamento entre Prescription e Consultation
        Prescription prescription = prescriptionMapper.toCreatePrescription(request.getPrescription());
        if (prescription != null) {
            newConsult.setPrescription(prescription);
            prescription.setConsultation(newConsult);
        }

        return consultMapper.toResponse(consultationRepository.save(newConsult));

    }
}

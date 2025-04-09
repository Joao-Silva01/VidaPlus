package com.RobDev.VidaPlus.services;

import com.RobDev.VidaPlus.dto.consultation.UpdateConsultRequest;
import com.RobDev.VidaPlus.dto.consultation.UpdateConsultResponse;
import com.RobDev.VidaPlus.entities.*;
import com.RobDev.VidaPlus.repositories.ConsultationRepository;
import com.RobDev.VidaPlus.repositories.HealthProfessionalRepository;
import com.RobDev.VidaPlus.repositories.PatientRepository;
import com.RobDev.VidaPlus.dto.consultation.ConsultResponse;
import com.RobDev.VidaPlus.dto.consultation.CreateConsultRequest;
import com.RobDev.VidaPlus.dto.patiente.AllConsultationsPatientResponse;
import com.RobDev.VidaPlus.mapper.consultation.ConsultationMapper;
import com.RobDev.VidaPlus.mapper.hospitalAdmission.HospitalAdmissionMapper;
import com.RobDev.VidaPlus.mapper.medicalExamination.MedicalExaminationMapper;
import com.RobDev.VidaPlus.mapper.patient.PatientMapper;
import com.RobDev.VidaPlus.mapper.prescription.PrescriptionMapper;
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

    public ConsultResponse createConsult(CreateConsultRequest request) {
        HealthProfessional professional = hpRepository.findById(request.getProfessional_id()).orElseThrow();
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

    public UpdateConsultResponse updateConsult(long consult_id, UpdateConsultRequest request){
        Consultation consult = consultationRepository.findById(consult_id).orElseThrow();

        consultMapper.requestUpdate(request, consult);
        return consultMapper.toUpdateResponse(consultationRepository.save(consult));
    }
}

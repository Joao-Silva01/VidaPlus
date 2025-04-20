package com.RobDev.VidaPlus.services;

import com.RobDev.VidaPlus.dto.SucessResponse;
import com.RobDev.VidaPlus.dto.medicalExamination.CreateExamRequest;
import com.RobDev.VidaPlus.dto.medicalExamination.ExamResponse;
import com.RobDev.VidaPlus.dto.medicalExamination.UpdateExamRequest;
import com.RobDev.VidaPlus.entities.Consultation;
import com.RobDev.VidaPlus.entities.MedicalExamination;
import com.RobDev.VidaPlus.exception.IdNotFoundException;
import com.RobDev.VidaPlus.mapper.MedicalExaminationMapper;
import com.RobDev.VidaPlus.repositories.ConsultationRepository;
import com.RobDev.VidaPlus.repositories.MedicalExaminationRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicalExaminationService {

    @Autowired
    private MedicalExaminationRepository examinationRepository;

    @Autowired
    private ConsultationRepository consultationRepository;

    @Autowired
    private MedicalExaminationMapper examinationMapper;

    @Transactional
    public SucessResponse examCreate(long consultId, CreateExamRequest request){
        Consultation consultation = consultationRepository.findById(consultId)
                .orElseThrow(() -> new IdNotFoundException("Query not found for exam creation"));
        
        MedicalExamination exam = examinationMapper.toCreateExam(request);
        exam.setConsultation(consultation);
        consultation.addRequestedExams(exam);

        examinationRepository.save(exam);
        return new SucessResponse("Exam created successfully");
    }

    @Transactional
    public SucessResponse examUpdate(long consultId, long examId, UpdateExamRequest request) {
        Consultation consultation = consultationRepository.findById(consultId)
                .orElseThrow(() -> new IdNotFoundException("Query not found for exam update!"));

        List<MedicalExamination> exams = consultation.getRequestedExams();

        for (MedicalExamination exam : exams){
            if(exam.getId() == examId){
                examinationMapper.requestUpdate(request, exam);
                examinationRepository.save(exam);
                return new SucessResponse("Exam updated successfully");
            }
        }

        return null;
    }

    @Transactional
    public void delete(long id){
        MedicalExamination exam = examinationRepository.findById(id).orElseThrow(
                () -> new IdNotFoundException("Exam not found")
        );
        examinationRepository.delete(exam);

    }
}

package com.RobDev.VidaPlus.services;

import com.RobDev.VidaPlus.dto.medicalExamination.ExamResponse;
import com.RobDev.VidaPlus.dto.medicalExamination.UpdateExamRequest;
import com.RobDev.VidaPlus.entities.Consultation;
import com.RobDev.VidaPlus.entities.MedicalExamination;
import com.RobDev.VidaPlus.mapper.medicalExamination.MedicalExaminationMapper;
import com.RobDev.VidaPlus.mapper.medicalExamination.MedicalExaminationUpdate;
import com.RobDev.VidaPlus.repositories.ConsultationRepository;
import com.RobDev.VidaPlus.repositories.MedicalExaminationRepository;
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
    private MedicalExaminationUpdate examinationUpdate;

    @Autowired
    private MedicalExaminationMapper examinationMapper;

    public ExamResponse ExamUpdate(long consultId, long examId, UpdateExamRequest request) {
        Consultation consultation = consultationRepository.findById(consultId).orElseThrow();
        List<MedicalExamination> exams = consultation.getRequestedExams();

        for (MedicalExamination exam : exams){
            if(exam.getId() == examId){
                examinationUpdate.requestUpdate(request, exam);
                return examinationMapper.toResponse(examinationRepository.save(exam));
            }
        }

        return null;
    }
}

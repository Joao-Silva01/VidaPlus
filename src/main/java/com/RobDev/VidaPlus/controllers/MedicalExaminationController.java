package com.RobDev.VidaPlus.controllers;

import com.RobDev.VidaPlus.dto.medicalExamination.CreateExamRequest;
import com.RobDev.VidaPlus.dto.medicalExamination.ExamResponse;
import com.RobDev.VidaPlus.dto.medicalExamination.UpdateExamRequest;
import com.RobDev.VidaPlus.services.MedicalExaminationService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/examination")
public class MedicalExaminationController {

    @Autowired
    private MedicalExaminationService medicalExaminationService;

    @PostMapping(value = "/{consultId}")
    @PreAuthorize("hasAnyAuthority('PROFESSIONAL','ADMIN', 'MAIN_ADMIN')")
    public ResponseEntity<ExamResponse> createExam(@PathVariable long consultId,
                                                   @Valid @RequestBody CreateExamRequest request){

        return ResponseEntity.ok().body(medicalExaminationService.examCreate(consultId,request));
    }

    @PutMapping(value = "/{consultId}/exam/{examId}")
    @PreAuthorize("hasAnyAuthority('PROFESSIONAL','ADMIN', 'MAIN_ADMIN')")
    public ResponseEntity<ExamResponse> updateExam(@PathVariable long consultId, @PathVariable long examId,
                                                   @Valid @RequestBody UpdateExamRequest request){

        return ResponseEntity.ok().body(medicalExaminationService.examUpdate(consultId,examId,request));
    }
}

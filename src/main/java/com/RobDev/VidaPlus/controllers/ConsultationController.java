package com.RobDev.VidaPlus.controllers;

import com.RobDev.VidaPlus.dto.consultation.ConsultResponse;
import com.RobDev.VidaPlus.dto.consultation.UpdateConsultRequest;
import com.RobDev.VidaPlus.dto.consultation.CreateConsultRequest;
import com.RobDev.VidaPlus.dto.consultation.UpdateConsultResponse;
import com.RobDev.VidaPlus.dto.hospitalAdmission.HospitalAdmissionResponse;
import com.RobDev.VidaPlus.dto.hospitalAdmission.UpdateHospitalAdmissionRequest;
import com.RobDev.VidaPlus.dto.medicalExamination.ExamResponse;
import com.RobDev.VidaPlus.dto.medicalExamination.UpdateExamRequest;
import com.RobDev.VidaPlus.dto.prescription.PrescriptionResponse;
import com.RobDev.VidaPlus.dto.prescription.UpdatePrescriptionRequest;
import com.RobDev.VidaPlus.services.ConsultationService;
import com.RobDev.VidaPlus.services.HospitalAdmissionService;
import com.RobDev.VidaPlus.services.MedicalExaminationService;
import com.RobDev.VidaPlus.services.PrescriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/consultation")
public class ConsultationController {

    @Autowired
    private ConsultationService consultationService;

    @Autowired
    private HospitalAdmissionService hospitalAdmissionService;

    @Autowired
    private MedicalExaminationService medicalExaminationService;

    @GetMapping(value = "/{consult_id}")
    public ResponseEntity<ConsultResponse> getById(@PathVariable long consult_id) {
        return ResponseEntity.ok().body(consultationService.getConsult(consult_id));
    }

    @GetMapping(value = "patient/{id}")
    public ResponseEntity<?> patientAllConsults(@PathVariable long id) {
        return ResponseEntity.ok().body(consultationService.getAllMedicalAppointmentsPatient(id));
    }

    @PostMapping
    public ResponseEntity<ConsultResponse> create(@RequestBody CreateConsultRequest request) {
        return ResponseEntity.ok().body(consultationService.createConsult(request));
    }

    @PutMapping(value = "/{consultId}")
    public ResponseEntity<UpdateConsultResponse> update(@PathVariable long consultId,
                                                        @RequestBody UpdateConsultRequest request) {

        return ResponseEntity.ok().body(consultationService.updateConsult(consultId, request));
    }

    @PutMapping(value = "/{consultId}/hospitalization")
    public ResponseEntity<HospitalAdmissionResponse> updateHospitalization(@PathVariable long consultId,
                                                                           @RequestBody UpdateHospitalAdmissionRequest request){

        return ResponseEntity.ok().body(hospitalAdmissionService.HospitalizationUpdate(consultId, request));
    }

    @PutMapping(value = "/{consultId}/exam/{examId}")
    public ResponseEntity<ExamResponse> updateExam(@PathVariable long consultId, @PathVariable long examId,
                                                   @RequestBody UpdateExamRequest request){

        return ResponseEntity.ok().body(medicalExaminationService.ExamUpdate(consultId,examId,request));
    }
}

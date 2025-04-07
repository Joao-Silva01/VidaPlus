package com.RobDev.VidaPlus.controllers;

import com.RobDev.VidaPlus.dto.consultation.ConsultResponse;
import com.RobDev.VidaPlus.dto.consultation.UpdateConsultRequest;
import com.RobDev.VidaPlus.dto.consultation.CreateConsultRequest;
import com.RobDev.VidaPlus.dto.hospitalAdmission.UpdateHospitalAdmissionRequest;
import com.RobDev.VidaPlus.dto.medicalExamination.UpdateExamRequest;
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
    private PrescriptionService prescriptionService;

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
    public ResponseEntity<?> update(@PathVariable long consultId,
                                    @RequestBody UpdateConsultRequest request) {
        consultationService.updateConsult(consultId, request);
        return ResponseEntity.ok().build();
    }

    @PutMapping(value = "/{consultId}/prescription")
    public ResponseEntity<?> updatePrescription(@PathVariable long consultId,
                                                @RequestBody UpdatePrescriptionRequest request) {
        prescriptionService.prescriptionUpdate(consultId, request);
        return ResponseEntity.ok().build();
    }

    @PutMapping(value = "/{consultId}/hospitalization")
    public ResponseEntity<?> updateHospitalization(@PathVariable long consultId,
                                                   @RequestBody UpdateHospitalAdmissionRequest request){
        hospitalAdmissionService.HospitalizationUpdate(consultId, request);

        return ResponseEntity.ok().build();
    }

    @PutMapping(value = "/{consultId}/exam/{examId}")
    public ResponseEntity<?> updateExam(@PathVariable long consultId, @PathVariable long examId,
                                        @RequestBody UpdateExamRequest request){
        medicalExaminationService.ExamUpdate(consultId,examId,request);
        return ResponseEntity.ok().build();
    }
}

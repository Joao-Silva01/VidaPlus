package com.RobDev.VidaPlus.controllers;

import com.RobDev.VidaPlus.dto.consultation.ConsultResponse;
import com.RobDev.VidaPlus.dto.consultation.CreateConsultRequest;
import com.RobDev.VidaPlus.services.ConsultationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/consultation")
public class ConsultationController {

    @Autowired
    private ConsultationService consultationService;

    @PostMapping(value = "/{professional_id}/create")
    public ResponseEntity<ConsultResponse> create(@PathVariable long professional_id, @RequestBody CreateConsultRequest request){

        return ResponseEntity.ok().body(consultationService.createConsult(professional_id, request));
    }
}

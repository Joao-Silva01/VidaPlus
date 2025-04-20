package com.RobDev.VidaPlus.controllers;

import com.RobDev.VidaPlus.dto.SucessResponse;
import com.RobDev.VidaPlus.dto.notification.NotificationRequest;
import com.RobDev.VidaPlus.services.EmailService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/email")
public class NotificationController {

    @Autowired
    private EmailService emailService;

    @PostMapping(value = "/{patientId}")
    @PreAuthorize("hasAnyAuthority('PROFESSIONAL','ADMIN', 'MAIN_ADMIN')")
    public ResponseEntity<SucessResponse> sendEmail(@PathVariable long patientId, @Valid @RequestBody NotificationRequest request){

        return ResponseEntity.ok().body(emailService.sendEmail(patientId,request));
    }
}

package com.RobDev.VidaPlus.controllers;

import com.RobDev.VidaPlus.dto.notification.NotificationRequest;
import com.RobDev.VidaPlus.services.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/email")
public class NotificationController {

    @Autowired
    private EmailService emailService;

    @PostMapping(value = "/{patientId}")
    public ResponseEntity<?> sendEmail(@PathVariable long patientId,@RequestBody NotificationRequest request){
        emailService.sendEmail(patientId,request);
        return ResponseEntity.ok().build();
    }
}

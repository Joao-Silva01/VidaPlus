package com.RobDev.VidaPlus.controllers;

import com.RobDev.VidaPlus.services.HealthProfessionalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/professional")
public class HealthProfessionalController {

    @Autowired
    private HealthProfessionalService hpService;
}

package com.RobDev.VidaPlus.services;

import com.RobDev.VidaPlus.Repositories.HealthProfessionalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HealthProfessionalService {

    @Autowired
    private HealthProfessionalRepository hpRepository;
}

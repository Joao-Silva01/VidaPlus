package com.RobDev.VidaPlus.services;

import com.RobDev.VidaPlus.Entities.Enums.UserRole;
import com.RobDev.VidaPlus.Repositories.HealthProfessionalRepository;
import com.RobDev.VidaPlus.dto.healthprofessional.CreateHpRequest;
import com.RobDev.VidaPlus.dto.healthprofessional.HpResponse;
import com.RobDev.VidaPlus.mapper.HealthProfessionalMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HealthProfessionalService {

    @Autowired
    private HealthProfessionalRepository hpRepository;

    @Autowired
    private HealthProfessionalMapper hpMapper;

    public List<HpResponse> allProfessionals(){
        return hpMapper.toList(hpRepository.findAll());
    }

    public HpResponse byId(long id){
        var professional = hpRepository.findById(id).orElseThrow();
        return hpMapper.toResponse(professional);
    }

    public HpResponse createProfessional(CreateHpRequest request){
        var newProfessional = hpMapper.toCreateEntity(request);
        newProfessional.setRole(UserRole.PROFESSIONAL);
        return hpMapper.toResponse(hpRepository.save(newProfessional));
    }
}

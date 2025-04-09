package com.RobDev.VidaPlus.services;

import com.RobDev.VidaPlus.entities.enums.UserRole;
import com.RobDev.VidaPlus.repositories.HealthProfessionalRepository;
import com.RobDev.VidaPlus.dto.healthProfessional.CreateHpRequest;
import com.RobDev.VidaPlus.dto.healthProfessional.HpResponse;
import com.RobDev.VidaPlus.dto.healthProfessional.UpdateHpRequest;
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

    public void updateProfessional(long id, UpdateHpRequest request){
        var professional = hpRepository.findById(id).orElseThrow();
        hpMapper.requestUpdate(request, professional);
        hpRepository.save(professional);
    }
}

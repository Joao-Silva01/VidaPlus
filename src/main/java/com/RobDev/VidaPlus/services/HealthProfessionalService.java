package com.RobDev.VidaPlus.services;

import com.RobDev.VidaPlus.Entities.Enums.UserRole;
import com.RobDev.VidaPlus.Repositories.HealthProfessionalRepository;
import com.RobDev.VidaPlus.dto.healthprofessional.CreateHpRequest;
import com.RobDev.VidaPlus.dto.healthprofessional.HpResponse;
import com.RobDev.VidaPlus.dto.healthprofessional.UpdateHpRequest;
import com.RobDev.VidaPlus.mapper.HealthProfessionalMapper;
import com.RobDev.VidaPlus.mapper.HealthProfessionalUpdate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HealthProfessionalService {

    @Autowired
    private HealthProfessionalRepository hpRepository;

    @Autowired
    private HealthProfessionalMapper hpMapper;

    @Autowired
    private HealthProfessionalUpdate hpUpdate;

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
        hpUpdate.update(request, professional);
        hpRepository.save(professional);
    }
}

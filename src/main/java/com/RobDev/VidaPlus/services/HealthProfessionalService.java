package com.RobDev.VidaPlus.services;

import com.RobDev.VidaPlus.dto.healthProfessional.HpAgendaResponse;
import com.RobDev.VidaPlus.entities.HealthProfessional;
import com.RobDev.VidaPlus.entities.enums.UserRole;
import com.RobDev.VidaPlus.exception.IdNotFoundException;
import com.RobDev.VidaPlus.exception.ThisAlreadyExistsException;
import com.RobDev.VidaPlus.repositories.HealthProfessionalRepository;
import com.RobDev.VidaPlus.dto.healthProfessional.CreateHpRequest;
import com.RobDev.VidaPlus.dto.healthProfessional.HpResponse;
import com.RobDev.VidaPlus.dto.healthProfessional.UpdateHpRequest;
import com.RobDev.VidaPlus.mapper.HealthProfessionalMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.List;

@Service
public class HealthProfessionalService {

    @Autowired
    private HealthProfessionalRepository hpRepository;

    @Autowired
    private HealthProfessionalMapper hpMapper;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public List<HpResponse> allProfessionals(){
        return hpMapper.toList(hpRepository.findAll());
    }

    public HpResponse byId(long id){
        HealthProfessional professional = hpRepository.findById(id)
                .orElseThrow(() -> new IdNotFoundException("Healthcare Professional not found!"));
        return hpMapper.toResponse(professional);
    }

    public HpResponse createProfessional(CreateHpRequest request){

        if(hpRepository.findByEmail(request.getEmail()).isPresent() || hpRepository.findByDocument(request.getDocument()).isPresent()){
            throw new ThisAlreadyExistsException("The email or document is already registered.");
        }

        HealthProfessional newProfessional = hpMapper.toCreateEntity(request);
        newProfessional.setRole(UserRole.PROFESSIONAL);
        newProfessional.setRegisterMoment(Timestamp.from(Instant.now()));
        newProfessional.setPassword(bCryptPasswordEncoder.encode(request.getPassword()));
        newProfessional.setSignature(bCryptPasswordEncoder.encode(request.getSignature()));

        return hpMapper.toResponse(hpRepository.save(newProfessional));
    }

    public void updateProfessional(long id, UpdateHpRequest request){
        HealthProfessional professional = hpRepository.findById(id)
                .orElseThrow(() -> new IdNotFoundException("Healthcare Professional not found for update!"));
        hpMapper.requestUpdate(request, professional);
        hpRepository.save(professional);
    }

    public HpAgendaResponse allCommitments(long id){
          var professional =  hpRepository.findById(id)
                  .orElseThrow(() -> new IdNotFoundException("Healthcare professional not found"));

          return hpMapper.toAllCommitmentsResponse(professional);

    }
}

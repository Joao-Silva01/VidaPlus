package com.RobDev.VidaPlus.services;

import com.RobDev.VidaPlus.dto.SucessResponse;
import com.RobDev.VidaPlus.dto.agenda.AgendaRequest;
import com.RobDev.VidaPlus.dto.agenda.AgendaResponse;
import com.RobDev.VidaPlus.entities.Agenda;
import com.RobDev.VidaPlus.entities.HealthProfessional;
import com.RobDev.VidaPlus.exception.IdNotFoundException;
import com.RobDev.VidaPlus.mapper.AgendaMapper;
import com.RobDev.VidaPlus.repositories.AgendaRepository;
import com.RobDev.VidaPlus.repositories.HealthProfessionalRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AgendaService {

    @Autowired
    private AgendaRepository agendaRepository;

    @Autowired
    private HealthProfessionalRepository hpRepository;

    @Autowired
    private AgendaMapper agendaMapper;

    @Transactional
    public SucessResponse markingAgenda(long professionalId, AgendaRequest request){
        var professional = hpRepository.findById(professionalId)
                .orElseThrow(() -> new IdNotFoundException("Professional not found to create the task"));
        Agenda newAgenda = agendaMapper.toRequest(request);
        newAgenda.setProfessional(professional);

       agendaRepository.save(newAgenda);
       return new SucessResponse("Task scheduled successfully");
    }

    @Transactional
    public SucessResponse updatingAgenda(long agendaId, AgendaRequest request){
        var agenda = agendaRepository.findById(agendaId)
                .orElseThrow(() -> new IdNotFoundException("Task not found for update"));

        agendaMapper.requestUpdate(request,agenda);

        agendaRepository.save(agenda);
        return new SucessResponse("Task updated successfully");
    }

    @Transactional
    public void delete(long id){
        var patient = agendaRepository.findById(id)
                .orElseThrow(() -> new IdNotFoundException("Task not found"));

        agendaRepository.delete(patient);
    }
}

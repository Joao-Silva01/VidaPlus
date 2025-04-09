package com.RobDev.VidaPlus.mapper.patient;


import com.RobDev.VidaPlus.dto.patiente.UpdatePatientRequest;
import com.RobDev.VidaPlus.entities.Patient;
import com.RobDev.VidaPlus.dto.patiente.AllConsultationsPatientResponse;
import com.RobDev.VidaPlus.dto.patiente.CreatePatientRequest;
import com.RobDev.VidaPlus.dto.patiente.PatientResponse;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface PatientMapper{

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "role", ignore = true)
    Patient toCreateEntity (CreatePatientRequest request);

    PatientResponse toResponseDTO(Patient entity);

    List<PatientResponse> toList(List<Patient> list);

    AllConsultationsPatientResponse toAllConsultationsResponse(Patient entity);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void requestUpdate(UpdatePatientRequest request, @MappingTarget Patient entity);
}

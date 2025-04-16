package com.RobDev.VidaPlus.mapper;


import com.RobDev.VidaPlus.dto.patiente.*;
import com.RobDev.VidaPlus.entities.Patient;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface PatientMapper{

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "role", ignore = true)
    @Mapping(target = "password", ignore = true)
    Patient toCreateEntity (CreatePatientRequest request);

    PatientResponse toResponseDTO(Patient entity);

    List<PatientResponse> toList(List<Patient> list);

    AllConsultationsPatientResponse toAllConsultationsResponse(Patient entity);

    PatientNotificationResponse toPatientNotification(Patient entity);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void requestUpdate(UpdatePatientRequest request, @MappingTarget Patient entity);
}

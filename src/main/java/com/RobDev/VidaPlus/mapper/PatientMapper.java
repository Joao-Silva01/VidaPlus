package com.RobDev.VidaPlus.mapper;


import com.RobDev.VidaPlus.Entities.Patient;
import com.RobDev.VidaPlus.dto.patiente.AllConsultationsPatientResponse;
import com.RobDev.VidaPlus.dto.patiente.CreatePatientRequest;
import com.RobDev.VidaPlus.dto.patiente.PatientResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface PatientMapper{

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "role", ignore = true)
    Patient toCreateEntity (CreatePatientRequest request);

    PatientResponse toResponseDTO(Patient entity);

    List<PatientResponse> toList(List<Patient> list);

    AllConsultationsPatientResponse toAllConsultationsResponse(Patient entity);
}

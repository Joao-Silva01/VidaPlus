package com.RobDev.VidaPlus.mapper;


import com.RobDev.VidaPlus.Entities.Patient;
import com.RobDev.VidaPlus.dto.CreatePatientRequest;
import com.RobDev.VidaPlus.dto.PatientResponse;
import com.RobDev.VidaPlus.dto.UpdatePatientRequest;
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
}

package com.RobDev.VidaPlus.mapper;


import com.RobDev.VidaPlus.Entities.Patient;
import com.RobDev.VidaPlus.dto.CreatePatientRequest;
import com.RobDev.VidaPlus.dto.PatientResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface PatientMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "role", ignore = true)
    Patient toEntity (CreatePatientRequest dto);

    PatientResponse toResponseDTO(Patient entity);
}

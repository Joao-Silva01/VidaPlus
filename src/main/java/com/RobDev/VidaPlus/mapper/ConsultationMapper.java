package com.RobDev.VidaPlus.mapper;

import com.RobDev.VidaPlus.Entities.Consultation;
import com.RobDev.VidaPlus.dto.consultation.CreateConsultRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface ConsultationMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "patient", ignore = true)
    Consultation toCreateConsult(CreateConsultRequest request);

}

package com.RobDev.VidaPlus.mapper.consultation;

import com.RobDev.VidaPlus.entities.Consultation;
import com.RobDev.VidaPlus.dto.consultation.ConsultResponse;
import com.RobDev.VidaPlus.dto.consultation.CreateConsultRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface ConsultationMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "patient", ignore = true)
    //@Mapping(target = "prescription", ignore = true)
    Consultation toCreateConsult(CreateConsultRequest request);

    ConsultResponse toResponse (Consultation entity);
}

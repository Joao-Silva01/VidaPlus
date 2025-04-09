package com.RobDev.VidaPlus.mapper;

import com.RobDev.VidaPlus.dto.consultation.UpdateConsultRequest;
import com.RobDev.VidaPlus.dto.consultation.UpdateConsultResponse;
import com.RobDev.VidaPlus.entities.Consultation;
import com.RobDev.VidaPlus.dto.consultation.ConsultResponse;
import com.RobDev.VidaPlus.dto.consultation.CreateConsultRequest;
import org.mapstruct.*;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface ConsultationMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "patient", ignore = true)
    @Mapping(target = "consultationFee", ignore = true)
    @Mapping(target = "consultationLink", ignore = true)
    Consultation toCreateConsult(CreateConsultRequest request);

    ConsultResponse toResponse (Consultation entity);

    UpdateConsultResponse toUpdateResponse(Consultation entity);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void requestUpdate(UpdateConsultRequest consultUpdate, @MappingTarget Consultation entity);
}

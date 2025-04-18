package com.RobDev.VidaPlus.mapper;

import com.RobDev.VidaPlus.dto.consultation.*;
import com.RobDev.VidaPlus.entities.Consultation;
import org.mapstruct.*;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface ConsultationMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "patient", ignore = true)
    @Mapping(target = "consultationFee", ignore = true)
    @Mapping(target = "consultationLink", ignore = true)
    Consultation toCreateConsult(CreateConsultRequest request);

    ConsultResponse toResponse (Consultation entity);

    ConsultationLinkResponse toConsultLinkResponse(Consultation entity);

    UpdateConsultResponse toUpdateResponse(Consultation entity);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void requestUpdate(UpdateConsultRequest consultUpdate, @MappingTarget Consultation entity);
}

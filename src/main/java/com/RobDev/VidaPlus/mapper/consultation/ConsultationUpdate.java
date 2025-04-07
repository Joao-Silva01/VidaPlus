package com.RobDev.VidaPlus.mapper.consultation;

import com.RobDev.VidaPlus.dto.consultation.UpdateConsultRequest;
import com.RobDev.VidaPlus.entities.Consultation;
import org.mapstruct.*;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface ConsultationUpdate {

    void requestUpdate(UpdateConsultRequest consultUpdate, @MappingTarget Consultation entity);
}

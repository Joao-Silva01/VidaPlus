package com.RobDev.VidaPlus.mapper.prescription;

import com.RobDev.VidaPlus.dto.prescription.UpdatePrescriptionRequest;
import com.RobDev.VidaPlus.entities.Prescription;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface PrescriptionUpdate {

    void requestUpdate(UpdatePrescriptionRequest request, @MappingTarget Prescription entity);
}

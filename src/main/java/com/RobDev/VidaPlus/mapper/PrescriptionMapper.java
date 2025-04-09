package com.RobDev.VidaPlus.mapper;

import com.RobDev.VidaPlus.dto.prescription.PrescriptionResponse;
import com.RobDev.VidaPlus.dto.prescription.UpdatePrescriptionRequest;
import com.RobDev.VidaPlus.entities.Prescription;
import com.RobDev.VidaPlus.dto.prescription.PrescriptionRequest;
import org.mapstruct.*;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface PrescriptionMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "consultation", ignore = true)
    @Mapping(target = "type", ignore = true)
    Prescription toCreatePrescription (PrescriptionRequest request);

    PrescriptionResponse toResponse(Prescription entity);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void requestUpdate(UpdatePrescriptionRequest request, @MappingTarget Prescription entity);
}

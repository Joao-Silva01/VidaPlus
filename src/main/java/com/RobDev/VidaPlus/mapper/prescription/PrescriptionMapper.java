package com.RobDev.VidaPlus.mapper.prescription;

import com.RobDev.VidaPlus.dto.prescription.PrescriptionResponse;
import com.RobDev.VidaPlus.entities.Prescription;
import com.RobDev.VidaPlus.dto.prescription.PrescriptionRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface PrescriptionMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "consultation", ignore = true)
    Prescription toCreatePrescription (PrescriptionRequest request);

    PrescriptionResponse toResponse(Prescription entity);
}

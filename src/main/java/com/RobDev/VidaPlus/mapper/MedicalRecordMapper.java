package com.RobDev.VidaPlus.mapper;

import com.RobDev.VidaPlus.dto.medicalRecord.CreateMedicalRecordRequest;
import com.RobDev.VidaPlus.dto.medicalRecord.MinMedicalRecordResponse;
import com.RobDev.VidaPlus.dto.medicalRecord.MedicalRecordResponse;
import com.RobDev.VidaPlus.dto.medicalRecord.UpdateMedicalRecordRequest;
import com.RobDev.VidaPlus.entities.MedicalRecord;
import org.mapstruct.*;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface MedicalRecordMapper {

    @Mapping(target = "patient", ignore = true)
    @Mapping(target = "professionals", ignore = true)
    MedicalRecord toCreateEntity(CreateMedicalRecordRequest request);

    MinMedicalRecordResponse toMinResponse(MedicalRecord entity);

    @Mapping(target = "professionals", ignore = true)
    MedicalRecordResponse toResponse(MedicalRecord entity);

    @Mapping(target = "professionals", ignore = true)
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void requestUpdate(UpdateMedicalRecordRequest request, @MappingTarget MedicalRecord entity);
}

package com.RobDev.VidaPlus.mapper.medicalExamination;

import com.RobDev.VidaPlus.dto.medicalExamination.UpdateExamRequest;
import com.RobDev.VidaPlus.entities.MedicalExamination;
import org.mapstruct.*;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface MedicalExaminationUpdate {

    void requestUpdate(UpdateExamRequest request, @MappingTarget MedicalExamination entity);
}

package com.RobDev.VidaPlus.mapper;

import com.RobDev.VidaPlus.dto.updateLog.UpdateLogRequest;
import com.RobDev.VidaPlus.dto.updateLog.UpdateLogResponse;
import com.RobDev.VidaPlus.entities.MedicalRecord;
import com.RobDev.VidaPlus.entities.UpdateLog;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface UpdateLogMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "medicalRecord", ignore = true)
    @Mapping(target = "professional", ignore = true)
    UpdateLog toRequest(UpdateLogRequest request);

    List<UpdateLogResponse> toListResponse (List<UpdateLog> listEntity);

    void logUpdateRequest(UpdateLogRequest request, @MappingTarget MedicalRecord entity);
}

package com.RobDev.VidaPlus.mapper;

import com.RobDev.VidaPlus.dto.report.ReportResponse;
import com.RobDev.VidaPlus.entities.Report;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface ReportMapper {

    ReportResponse toResponse(Report enitty);

    List<ReportResponse> toListResponse(List<Report> listEntity);
}

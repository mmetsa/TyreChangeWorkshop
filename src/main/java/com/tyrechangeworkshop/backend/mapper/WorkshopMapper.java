package com.tyrechangeworkshop.backend.mapper;

import com.tyrechangeworkshop.backend.dto.WorkshopResponse;
import com.tyrechangeworkshop.backend.entity.Workshop;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface WorkshopMapper {
    WorkshopResponse toResponse(Workshop workshop);

    List<WorkshopResponse> toListResponse(List<Workshop> workshops);
}

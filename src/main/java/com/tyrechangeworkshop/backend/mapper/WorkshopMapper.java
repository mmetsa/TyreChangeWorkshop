package com.tyrechangeworkshop.backend.mapper;

import com.tyrechangeworkshop.backend.controller.dto.WorkshopResponse;
import com.tyrechangeworkshop.backend.entity.Workshop;
import com.tyrechangeworkshop.backend.service.dto.WorkshopDTO;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface WorkshopMapper {
    WorkshopDTO toDTO(Workshop workshop);

    List<WorkshopDTO> toDTOList(List<Workshop> workshops);

    WorkshopResponse toResponse(WorkshopDTO workshop);

    List<WorkshopResponse> toListResponse(List<WorkshopDTO> workshops);
}

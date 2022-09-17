package com.tyrechangeworkshop.backend.service;

import com.tyrechangeworkshop.backend.dto.WorkshopResponse;
import com.tyrechangeworkshop.backend.mapper.WorkshopMapper;
import com.tyrechangeworkshop.backend.repository.WorkshopRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class WorkshopService {

    private final WorkshopRepository repository;
    private final WorkshopMapper workshopMapper;

    public List<WorkshopResponse> getWorkshopsByCity(String city) {
        // If city is not specified, return all the workshops
        if (city == null) {
            return workshopMapper.toListResponse(repository.findAll());
        }

        return workshopMapper.toListResponse(repository.findAllByAddressContainingIgnoreCase(city));
    }

}

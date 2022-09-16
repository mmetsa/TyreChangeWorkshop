package com.tyrechangeworkshop.backend.service;

import com.tyrechangeworkshop.backend.repository.WorkshopRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class WorkshopService {

    private final WorkshopRepository repository;

}

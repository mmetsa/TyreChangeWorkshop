package com.tyrechangeworkshop.backend.service;

import com.tyrechangeworkshop.backend.repository.TimeslotRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TimeslotService {

    private final TimeslotRepository repository;

}

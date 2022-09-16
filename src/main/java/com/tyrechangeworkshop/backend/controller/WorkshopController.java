package com.tyrechangeworkshop.backend.controller;

import com.tyrechangeworkshop.backend.service.WorkshopService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class WorkshopController {

    private final WorkshopService workshopService;

}

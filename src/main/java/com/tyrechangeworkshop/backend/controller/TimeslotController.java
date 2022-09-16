package com.tyrechangeworkshop.backend.controller;

import com.tyrechangeworkshop.backend.service.TimeslotService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class TimeslotController {

    private final TimeslotService timeslotService;

}

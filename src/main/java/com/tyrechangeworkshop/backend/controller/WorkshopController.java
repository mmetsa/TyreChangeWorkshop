package com.tyrechangeworkshop.backend.controller;

import com.tyrechangeworkshop.backend.controller.dto.WorkshopResponse;
import com.tyrechangeworkshop.backend.service.WorkshopService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/workshop")
@RequiredArgsConstructor
public class WorkshopController {

    private final WorkshopService workshopService;

    @GetMapping( {"/list", "/list/{city}"})
    public ResponseEntity<List<WorkshopResponse>> getWorkshops(@PathVariable(required = false) String city) {

        var response = workshopService.getWorkshopsByCity(city);

        return ResponseEntity.ok(response);
    }

}

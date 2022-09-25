package com.tyrechangeworkshop.backend.controller.dto;

import lombok.Data;

@Data
public class WorkshopResponse {
    private Long id;
    private String name;
    private String description;
    private String address;
}

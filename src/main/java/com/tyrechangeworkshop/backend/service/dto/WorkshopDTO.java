package com.tyrechangeworkshop.backend.service.dto;

import lombok.Data;

@Data
public class WorkshopDTO {

    private Long id;
    private String name;
    private String description;
    private String address;

}

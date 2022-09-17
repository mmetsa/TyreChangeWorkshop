package com.tyrechangeworkshop.backend.mapper;


import com.tyrechangeworkshop.backend.dto.WorkshopResponse;
import com.tyrechangeworkshop.backend.entity.Workshop;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WorkshopMapperTest {

    private static final String ADDRESS = "Väikeoja 12-4, Lammasmäe, Löövimaa";
    private static final String NAME = "Suur Suur Väikeoja Lammasmäe Nimi";
    private static final String DESCRIPTION = "On jälle aeg selg sirgu lüüa Ja heita endalt orjarüü";

    private final WorkshopMapper workshopMapper = Mappers.getMapper(WorkshopMapper.class);

    @Test
    void toResponse_allFieldsSet_mapsCorrectly() {

        // Arrange
        Workshop workshop = buildWorkshop();

        // Act
        WorkshopResponse response = workshopMapper.toResponse(workshop);

        // Assert
        assertEquals(workshop.getAddress(), response.getAddress());
        assertEquals(workshop.getDescription(), response.getDescription());
        assertEquals(workshop.getId(), response.getId());
        assertEquals(workshop.getName(), response.getName());
    }

    @Test
    void toListResponse_allFieldsSet_mapsCorrectly() {

        // Arrange
        List<Workshop> workshops = new ArrayList<>();
        workshops.add(buildWorkshop());
        workshops.add(buildWorkshop());

        // Act
        List<WorkshopResponse> response = workshopMapper.toListResponse(workshops);

        // Assert
        assertEquals(response.size(), workshops.size());
        assertEquals(workshops.get(0).getAddress(), response.get(0).getAddress());
        assertEquals(workshops.get(0).getDescription(), response.get(0).getDescription());
        assertEquals(workshops.get(0).getId(), response.get(0).getId());
        assertEquals(workshops.get(0).getName(), response.get(0).getName());

        assertEquals(workshops.get(1).getAddress(), response.get(1).getAddress());
        assertEquals(workshops.get(1).getDescription(), response.get(1).getDescription());
        assertEquals(workshops.get(1).getId(), response.get(1).getId());
        assertEquals(workshops.get(1).getName(), response.get(1).getName());
    }


    private Workshop buildWorkshop() {
        Workshop workshop = new Workshop();
        workshop.setAddress(ADDRESS);
        workshop.setDescription(DESCRIPTION);
        workshop.setId(1L);
        workshop.setName(NAME);

        return workshop;
    }


}

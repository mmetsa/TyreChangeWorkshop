package com.tyrechangeworkshop.backend.service;

import com.tyrechangeworkshop.backend.dto.WorkshopResponse;
import com.tyrechangeworkshop.backend.mapper.WorkshopMapper;
import com.tyrechangeworkshop.backend.repository.WorkshopRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class WorkshopServiceTest {

    @Mock
    private WorkshopRepository workshopRepository;

    @Mock
    private WorkshopMapper workshopMapper;

    @InjectMocks
    private WorkshopService workshopService;

    @Test
    void getWorkshopsByCity_noCitySpecified_findsAllWorkshops() {

        // Arrange
        String city = null;
        List<WorkshopResponse> response = new ArrayList<>();

        // Act
        when(workshopRepository.findAll()).thenReturn(new ArrayList<>());

        // Assert
        var result = workshopService.getWorkshopsByCity(city);
        assertEquals(result, response);
        verify(workshopRepository).findAll();
        verify(workshopRepository, times(0)).findAllByAddressContainingIgnoreCase(any());
    }

    @Test
    void getWorkshopsByCity_citySpecified_findsCityWorkshops() {

        // Arrange
        String city = "Tallinn";
        List<WorkshopResponse> response = new ArrayList<>();

        // Act
        when(workshopRepository.findAllByAddressContainingIgnoreCase(city)).thenReturn(new ArrayList<>());

        // Assert
        var result = workshopService.getWorkshopsByCity(city);
        assertEquals(result, response);
        verify(workshopRepository, times(0)).findAll();
        verify(workshopRepository).findAllByAddressContainingIgnoreCase(any());
    }
}

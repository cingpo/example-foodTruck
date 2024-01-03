package com.cingpo.foodtruck.service.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.data.jpa.domain.Specification;

import com.cingpo.foodtruck.model.MobileFoodFacilityEntity;
import com.cingpo.foodtruck.model.QueryListSelect;
import com.cingpo.foodtruck.repository.MobileFoodFacilityRepository;

public class MobileFoodFacilityServiceImplTest {

    @InjectMocks
    private MobileFoodFacilityServiceImpl mobileFoodFacilityService;

    @Mock
    private MobileFoodFacilityRepository mobileFoodFacilityRepository;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testListQuery() {
        // Mocking the QueryListSelect object
        QueryListSelect req = mock(QueryListSelect.class);

        // Mocking the list of MobileFoodFacilityEntity
        List<MobileFoodFacilityEntity> mobileFoodFacilityList = new ArrayList<>();
        mobileFoodFacilityList.add(mock(MobileFoodFacilityEntity.class));

        // Mocking the mobileFoodFacilityRepository.findAll() method
        when(mobileFoodFacilityRepository.findAll(any(Specification.class))).thenReturn(mobileFoodFacilityList);

        // Calling the listQuery method
        List<MobileFoodFacilityEntity> result = mobileFoodFacilityService.listQuery(req);

        // Verifying the interactions and assertions
        verify(mobileFoodFacilityRepository, times(1)).findAll(any(Specification.class));
        assertEquals(mobileFoodFacilityList, result);
    }

    // Add more test methods as needed
}
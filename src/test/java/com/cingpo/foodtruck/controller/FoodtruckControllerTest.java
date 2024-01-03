package com.cingpo.foodtruck.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.ui.Model;

import com.cingpo.foodtruck.model.MobileFoodFacilityEntity;
import com.cingpo.foodtruck.model.QueryListSelect;
import com.cingpo.foodtruck.service.MobileFoodFacilityService;

import jakarta.servlet.http.HttpServletRequest;

@ExtendWith(MockitoExtension.class)
public class FoodtruckControllerTest {

    @InjectMocks
    private FoodtruckController foodtruckController;

    @Mock
    private MobileFoodFacilityService mobileFoodFacilityService;

    @Test
    public void testSearch() {
        // Mocking the HttpServletRequest, Model, and MobileFoodFacilityEntity
        HttpServletRequest request = mock(HttpServletRequest.class);
        Model model = mock(Model.class);
        MobileFoodFacilityEntity mobileFoodFacilityEntity = mock(MobileFoodFacilityEntity.class);

        // Setting up the request parameters
        when(request.getParameter("facilityType")).thenReturn("type");
        when(request.getParameter("applicant")).thenReturn("applicant");
        when(request.getParameter("foodItems")).thenReturn("food");

        // Mocking the list of MobileFoodFacilityEntity
        List<MobileFoodFacilityEntity> mobileFoodFacilityList = new ArrayList<>();
        mobileFoodFacilityList.add(mobileFoodFacilityEntity);

        // Mocking the mobileFoodFacilityService.listQuery() method
        when(mobileFoodFacilityService.listQuery(any(QueryListSelect.class))).thenReturn(mobileFoodFacilityList);

        // Calling the search method
        String result = foodtruckController.search(request, new HashMap<>(), model);

        // Verifying the interactions and assertions
        verify(request, times(1)).getParameter("facilityType");
        verify(request, times(1)).getParameter("applicant");
        verify(request, times(1)).getParameter("foodItems");
        verify(mobileFoodFacilityService, times(1)).listQuery(any(QueryListSelect.class));
        verify(model, times(1)).addAttribute(eq("list"), eq(mobileFoodFacilityList));
        verify(model, times(1)).addAttribute(eq("queryListSelect"), any(QueryListSelect.class));
        assertEquals("index", result);
    }
}
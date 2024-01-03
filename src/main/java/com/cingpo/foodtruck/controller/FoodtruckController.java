package com.cingpo.foodtruck.controller;

import com.cingpo.foodtruck.model.MobileFoodFacilityEntity;
import com.cingpo.foodtruck.model.QueryListSelect;
import com.cingpo.foodtruck.service.MobileFoodFacilityService;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Controller
public class FoodtruckController {

    @Resource
    private MobileFoodFacilityService mobileFoodFacilityService;

    @RequestMapping(path = "/", method = {RequestMethod.GET, RequestMethod.POST})
    public String search(HttpServletRequest request, Map<String,Object> map, Model model) {
        String facilityType = request.getParameter("facilityType");
        String applicant = request.getParameter("applicant");
        String foodItems = request.getParameter("foodItems");
        QueryListSelect queryListSelect = QueryListSelect.builder()
                .applicant(applicant)
                .facilityType(facilityType)
                .foodItems(foodItems)
                .build();

        List<MobileFoodFacilityEntity> mobileFoodFacilityList = mobileFoodFacilityService.listQuery(queryListSelect);
        model.addAttribute("list", mobileFoodFacilityList);
        model.addAttribute("queryListSelect", queryListSelect);
        return "index";
    }
}

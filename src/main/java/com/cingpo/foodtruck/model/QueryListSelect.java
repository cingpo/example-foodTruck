package com.cingpo.foodtruck.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class QueryListSelect {
    private String facilityType;
    private String applicant;
    private String foodItems;
}

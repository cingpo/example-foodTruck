package com.cingpo.foodtruck.jopo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "MOBILE_FOOD_FACILITIES_PERMIT")
public class MobileFoodFacilityEntity {

    @Id
    @Column(name = "LOCATION_ID")
    private Integer locationId;

    @Column(name = "APPLICANT")
    private String applicant;

    @Column(name = "FACILITY_TYPE")
    private String facilityType;

    @Column(name = "LOCATION_DESCRIPTION")
    private String locationDescription;

    @Column(name = "ADDRESS")
    private String address;

    @Column(name = "STATUS")
    private String status;

    @Column(name = "FOOD_ITEMS")
    private String foodItems;

    @Column(name = "X")
    private Float x;

    @Column(name = "Y")
    private Float y;

    @Column(name = "LATITUDE")
    private Float latitude;

    @Column(name = "LONGITUDE")
    private Float longitude;

    @Column(name = "LOCATION")
    private String location;

    @Column(name = "ZIP")
    private Integer zip;
}

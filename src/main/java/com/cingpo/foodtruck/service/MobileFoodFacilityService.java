package com.cingpo.foodtruck.service;

import com.cingpo.foodtruck.model.MobileFoodFacilityEntity;
import com.cingpo.foodtruck.model.QueryListSelect;

import java.util.List;

public interface MobileFoodFacilityService {

    List<MobileFoodFacilityEntity> list();

    List<MobileFoodFacilityEntity> listQuery(QueryListSelect req);
}

package com.cingpo.foodtruck.service;

import com.cingpo.foodtruck.jopo.MobileFoodFacilityEntity;
import com.cingpo.foodtruck.jopo.QueryListSelect;

import java.util.List;

public interface MobileFoodFacilityService {

    List<MobileFoodFacilityEntity> list();

    List<MobileFoodFacilityEntity> listQuery(QueryListSelect req);
}

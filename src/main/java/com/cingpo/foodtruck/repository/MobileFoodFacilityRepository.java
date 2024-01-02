package com.cingpo.foodtruck.repository;

import com.cingpo.foodtruck.jopo.MobileFoodFacilityEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MobileFoodFacilityRepository extends JpaRepository<MobileFoodFacilityEntity, Integer>, JpaSpecificationExecutor<MobileFoodFacilityEntity> {
}

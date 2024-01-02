package com.cingpo.foodtruck.service.impl;

import com.cingpo.foodtruck.model.MobileFoodFacilityEntity;
import com.cingpo.foodtruck.model.QueryListSelect;
import com.cingpo.foodtruck.repository.MobileFoodFacilityRepository;
import com.cingpo.foodtruck.service.MobileFoodFacilityService;
import jakarta.annotation.Resource;
import jakarta.persistence.criteria.Predicate;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.thymeleaf.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class MobileFoodFacilityServiceImpl implements MobileFoodFacilityService {

    @Resource
    private MobileFoodFacilityRepository mobileFoodFacilityRepository;

    @Override
    public List<MobileFoodFacilityEntity> list() {
        return mobileFoodFacilityRepository.findAll();
    }

    public List<MobileFoodFacilityEntity> listQuery(QueryListSelect req) {
        try {
            //创建查询规范
            Specification<MobileFoodFacilityEntity> tvSpecification = (root, query, cb) -> {
                List<Predicate> predicateList = new ArrayList<>();
                if (!StringUtils.isEmptyOrWhitespace(req.getFacilityType())) {
                    predicateList.add(cb.equal(root.get("facilityType").as(String.class), req.getFacilityType()));
                }
                if (!StringUtils.isEmptyOrWhitespace(req.getApplicant())) {
                    predicateList.add(cb.like(root.get("applicant").as(String.class), "%" + req.getApplicant() + "%"));
                }
                if (!StringUtils.isEmptyOrWhitespace(req.getFoodItems())) {
                    predicateList.add(cb.like(root.get("foodItems").as(String.class), "%" + req.getFoodItems() + "%"));
                }
//                if (req.getTranBeginDate() != null && req.getTranEndDate() != null) {
//                    predicateList.add(cb.greaterThanOrEqualTo(root.get("tranDate").as(String.class), req.getTranBeginDate()));//greaterThanOrEqualTo(>=)
//                    predicateList.add(cb.lessThanOrEqualTo(root.get("tranDate").as(String.class), req.getTranEndDate()));//lessThanOrEqualTo(<=)
//                }
//                if (req.getOrderId() != null) {
//                    predicateList.add(cb.equal(root.get("orderId").as(Long.class), req.getOrderId()));//equal(=)
//                }
//                if (req.getVmId() != null && !"".equals(req.getVmId())) {
//                    predicateList.add(cb.equal(root.get("vmId").as(String.class), req.getVmId()));
//                    //like模糊查询 cb.like(root.get("name").as(String.class), "%" + req.getName() + "%");
//                }
//                if (req.getCcStatus() != null) {
//                    predicateList.add(cb.equal(root.get("ccStatus").as(Integer.class), req.getCcStatus()));
//                }
                Predicate[] predicates = new Predicate[predicateList.size()];
                return query.where(predicateList.toArray(predicates)).getRestriction();
            };

            //带有分页的复杂动态查询。Sort.Direction.DESC,"id"可去掉，这个是按某个字段排序
//            Page<MobileFoodFacilityEntity> all = mobileFoodFacilityRepository.findAll(tvSpecification, PageRequest.of(req.getPage(),req.getPageSize(),Sort.Direction.DESC,"id"));

            //没有分页的复杂动态查询。
            return mobileFoodFacilityRepository.findAll(tvSpecification);

        }catch (Exception e) {
            log.error("列表查询出错:{}", e.getMessage(), e);
            return List.of();
        }
    }
}

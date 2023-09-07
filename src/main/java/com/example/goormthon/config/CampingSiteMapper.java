package com.example.goormthon.config;

import com.example.goormthon.model.dao.CampingSiteDao;
import com.example.goormthon.model.entity.CampingSite;

import java.util.List;
import java.util.stream.Collectors;

public class CampingSiteMapper {
    public static CampingSiteDao mapEntityToDao(CampingSite campingSite) {
        return CampingSiteDao.builder()
                .id(campingSite.getId())
                .businessName(campingSite.getBusinessName())
                .phoneNumber(campingSite.getPhoneNumber())
                // 나머지 필드 매핑
                .build();
    }

    public static List<CampingSiteDao> mapEntitiesToDaos(List<CampingSite> campingSites) {
        return campingSites.stream()
                .map(CampingSiteMapper::mapEntityToDao)
                .collect(Collectors.toList());
    }
}

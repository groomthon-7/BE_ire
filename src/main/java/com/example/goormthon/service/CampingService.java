package com.example.goormthon.service;

import com.example.goormthon.config.CampingSiteMapper;
import com.example.goormthon.model.dao.CampingSiteDao;
import com.example.goormthon.model.dto.TagDto;
import com.example.goormthon.model.entity.CampingSite;
import com.example.goormthon.model.repository.CampingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CampingService {

    private final CampingRepository campingRepository;
    public static CampingSiteDao getAllJeju(TagDto tagDto) {
        return null;
    }
    private String generateTagsFromCampingTag(TagDto tag){
        return null;
    }

    public List<CampingSiteDao> getAllCampingSites() {

        List<CampingSite> campingSites = campingRepository.findAll();
        return CampingSiteMapper.mapEntitiesToDaos(campingSites);
    }
}

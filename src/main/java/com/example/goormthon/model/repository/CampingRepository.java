package com.example.goormthon.model.repository;

import com.example.goormthon.model.dao.CampingSiteDao;
import com.example.goormthon.model.entity.CampingSite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CampingRepository extends JpaRepository<CampingSite,Integer> {
    List<CampingSite> findByAddressContaining(String keyword);

    List<CampingSite> findByTagsContaining(String keyword);
}


/*
* if(클라이언트가 혼자 or 친구 or 연인 or 가족) :
*
*
* */
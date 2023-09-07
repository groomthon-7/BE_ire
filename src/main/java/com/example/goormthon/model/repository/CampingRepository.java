package com.example.goormthon.model.repository;

import com.example.goormthon.model.dao.CampingSiteDao;
import com.example.goormthon.model.entity.CampingSite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CampingRepository extends JpaRepository<CampingSite,Integer> {

}

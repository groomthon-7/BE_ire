package com.example.goormthon.model.repository;

import com.example.goormthon.model.entity.Seogipo;
import io.swagger.models.auth.In;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SeogipoRepository extends JpaRepository<Seogipo, Integer> {
}

package com.example.goormthon.model.repository;

import com.example.goormthon.model.entity.Jeju;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface JejuRepository extends JpaRepository<Jeju, Integer> {
    Optional<Jeju> findByAddressContaining(String keyword);
}

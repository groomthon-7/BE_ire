package com.example.goormthon.model.repository;

import com.example.goormthon.model.Members;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MemberRepository extends JpaRepository<Members,Long> {
    Optional<Members> findByLoginEmail(String email);
}

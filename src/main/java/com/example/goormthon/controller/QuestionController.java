package com.example.goormthon.controller;

import com.example.goormthon.model.dao.CampingSiteDao;
import com.example.goormthon.model.dto.TagDto;
import com.example.goormthon.model.repository.CampingRepository;
import com.example.goormthon.service.CampingService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/api")
public class QuestionController {

    private final CampingService campingService;

    private final CampingRepository campingRepository;
    @GetMapping("/ques")
    public ResponseEntity<CampingSiteDao> getJejuCamping(@RequestBody TagDto tagDto){
        return ResponseEntity.ok(campingService.getAllJeju(tagDto));
    }

    @GetMapping("/ques/all")
    public ResponseEntity<List<CampingSiteDao>> getAllJejuCamping(){
        List<CampingSiteDao> campingSites = campingService.getAllCampingSites();
        return ResponseEntity.ok(campingSites);
    }
}

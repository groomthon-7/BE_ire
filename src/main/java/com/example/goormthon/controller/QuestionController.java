package com.example.goormthon.controller;

import com.example.goormthon.model.dto.detailsDto;
import com.example.goormthon.model.entity.CampingSite;
import com.example.goormthon.model.entity.Jeju;
import com.example.goormthon.model.entity.Seogipo;
import com.example.goormthon.model.repository.CampingRepository;
import com.example.goormthon.model.repository.JejuRepository;
import com.example.goormthon.model.repository.SeogipoRepository;
import com.example.goormthon.service.CampingService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/api")
public class QuestionController {

    private final CampingService campingService;

    private final CampingRepository campingRepository;
    private final JejuRepository jejuRepository;
    private final SeogipoRepository seogipoRepository;
    @GetMapping("/ques/gettag")
    public  List<CampingSite> getTag(@RequestParam String tag){
        return campingService.getAllJeju(tag);
    }

    @GetMapping("/ques/all")
    public List<CampingSite> getAllCampingSites() {
        return campingService.findAllCampingSites();
    }
    @GetMapping("/camping-in-jeju")
    public List<Jeju> getCampingInJeju() {
        return jejuRepository.findAll();
//        return campingService.getCampingInJeju();
    }

    @GetMapping("/camping-in-seogipo")
    public List<Seogipo> getCampingInSeogwipo() {
        return seogipoRepository.findAll();
//        return campingService.getCampingInSeogwipo();
    }
    @GetMapping("/find-complex")
    public List<CampingSite> findComplex(){
        return campingRepository.findByAddressContaining("조천읍");
    }
    @GetMapping("/details")
    public detailsDto getOneDetails(@RequestParam String id){
        CampingSite campingSite = campingRepository.findById(id).get();
        return detailsDto.from(campingSite);
    }

}

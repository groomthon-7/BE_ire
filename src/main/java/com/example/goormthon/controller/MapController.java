package com.example.goormthon.controller;

import com.example.goormthon.authentication.kakao.KakaoApiClient;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class MapController {

    private final KakaoApiClient kakaoMapsService;

    @GetMapping("/search")
    public String searchMT1Nearby(
            @RequestParam(name = "latitude") double latitude,
            @RequestParam(name = "longitude") double longitude,
            @RequestParam(name = "keyword") String keyword) {
        return kakaoMapsService.searchMT1Nearby(latitude, longitude,keyword);
    }
}
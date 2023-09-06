package com.example.goormthon.controller;

import com.example.goormthon.authentication.kakao.KakaoLoginParams;
import com.example.goormthon.authentication.security.AuthTokens;
import com.example.goormthon.service.KakaoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class KakaoController {

    private final KakaoService kakaoService;
    //private final TokenService tokenService;
    @PostMapping("/kakao/login")
    public ResponseEntity<AuthTokens> loginKakao(@RequestBody KakaoLoginParams kakaoAccessCode) {

        AuthTokens authTokens = kakaoService.login(kakaoAccessCode);
        //tokenService.saveRefreshToken(authTokens.getRefreshToken(), authTokens.getJwtAccessToken());

        return ResponseEntity.ok(authTokens);
    }
    @ResponseBody
    @GetMapping("/kakao/callback")
    public ResponseEntity<String> kakaoCallback(@RequestParam String code) {

        return ResponseEntity.ok(code);
    }
}

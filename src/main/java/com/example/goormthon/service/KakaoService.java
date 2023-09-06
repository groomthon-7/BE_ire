package com.example.goormthon.service;

import com.example.goormthon.authentication.Jwt.RequestOAuthInfoService;
import com.example.goormthon.authentication.OauthInterface.OAuthInfoResponse;
import com.example.goormthon.authentication.OauthInterface.OAuthLoginParams;
import com.example.goormthon.authentication.kakao.KakaoApiClient;
import com.example.goormthon.authentication.security.AuthTokens;
import com.example.goormthon.authentication.security.AuthTokensGenerator;
import com.example.goormthon.model.Members;
import com.example.goormthon.model.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class KakaoService {
    private final MemberRepository memberRepository;
    private final AuthTokensGenerator authTokensGenerator;
    private final RequestOAuthInfoService requestOAuthInfoService;


    public AuthTokens login(OAuthLoginParams kakaoAccessCode) {

        OAuthInfoResponse oAuthInfoResponse = requestOAuthInfoService.request(kakaoAccessCode);
        Long memberId = findOrCreateMember(oAuthInfoResponse);

        return authTokensGenerator.generate(memberId);
    }


    private Long findOrCreateMember(OAuthInfoResponse oAuthInfoResponse) {

        return memberRepository.findByLoginEmail(oAuthInfoResponse.getEmail())
                .map(Members::getMemberId)
                .orElseGet(() -> newMember(oAuthInfoResponse));
    }


    private Long newMember(OAuthInfoResponse oAuthInfoResponse) {

        Members member = Members.builder()
                .loginEmail(oAuthInfoResponse.getEmail())
                .nickname(oAuthInfoResponse.getNickName())
                .build();

        return memberRepository.save(member).getMemberId();
    }

}

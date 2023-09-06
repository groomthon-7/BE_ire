package com.example.goormthon.authentication.Jwt;

import com.example.goormthon.authentication.OauthInterface.OAuthApiClient;
import com.example.goormthon.authentication.OauthInterface.OAuthInfoResponse;
import com.example.goormthon.authentication.OauthInterface.OAuthLoginParams;
import com.example.goormthon.authentication.kakao.OAuthProvider;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Component

public class RequestOAuthInfoService {

    private final Map<OAuthProvider, OAuthApiClient> clients;
    public RequestOAuthInfoService(List<OAuthApiClient> clients) {

        this.clients = clients.stream().collect(
                Collectors.toUnmodifiableMap(OAuthApiClient::oAuthProvider, Function.identity())
        );
    }

    public OAuthInfoResponse request(OAuthLoginParams kakaoAccessCode) {

        OAuthApiClient client = clients.get(kakaoAccessCode.oAuthProvider());
        String accessToken = client.requestAccessToken(kakaoAccessCode);
        return client.requestOauthInfo(accessToken);
    }


    public String getAccessToken(OAuthLoginParams accessCode) {

        OAuthApiClient client = clients.get(accessCode.oAuthProvider());
        return client.requestAccessToken(accessCode);
    }
}

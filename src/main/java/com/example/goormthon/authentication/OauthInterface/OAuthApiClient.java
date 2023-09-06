package com.example.goormthon.authentication.OauthInterface;

import com.example.goormthon.authentication.kakao.OAuthProvider;

public interface OAuthApiClient {

    OAuthProvider oAuthProvider();
    String requestAccessToken(OAuthLoginParams params);

    OAuthInfoResponse requestOauthInfo(String accessToken);

}

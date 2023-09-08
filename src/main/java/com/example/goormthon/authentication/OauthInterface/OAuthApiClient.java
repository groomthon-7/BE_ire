package com.example.goormthon.authentication.OauthInterface;

import com.example.goormthon.authentication.kakao.OAuthProvider;

public interface OAuthApiClient {

    OAuthProvider oAuthProvider();
    String requestAccessToken(OAuthLoginParams params);

//    void sendRequest();
    OAuthInfoResponse requestOauthInfo(String accessToken);

    String searchMT1Nearby(double latitude,double longitude,String keyword);

}

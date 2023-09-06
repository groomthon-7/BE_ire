package com.example.goormthon.authentication.OauthInterface;

import com.example.goormthon.authentication.kakao.OAuthProvider;
import org.springframework.util.MultiValueMap;

public interface OAuthLoginParams {

    MultiValueMap<String, String> makeBody();

    OAuthProvider oAuthProvider();
}

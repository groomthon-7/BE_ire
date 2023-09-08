package com.example.goormthon.authentication.kakao;

import com.example.goormthon.authentication.OauthInterface.OAuthApiClient;
import com.example.goormthon.authentication.OauthInterface.OAuthInfoResponse;
import com.example.goormthon.authentication.OauthInterface.OAuthLoginParams;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Component
@RequiredArgsConstructor
public class KakaoApiClient implements OAuthApiClient {

    private static final String GRANT_TYPE = "authorization_code";

    @Value("${oauth.kakao.url.auth}")
    private String authUrl;
    @Value("${oauth.kakao.url.api}")
    private String apiUrl;
    @Value("${oauth.kakao.client-id}")
    private String clientId;
    private final RestTemplate restTemplate;


    @Override
    public OAuthProvider oAuthProvider() {
        return OAuthProvider.KAKAO;
    }

    @Override
    public String requestAccessToken(OAuthLoginParams params) {

        String url = authUrl + "/oauth/token";

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        MultiValueMap<String, String> body = params.makeBody();
        body.add("grant_type", GRANT_TYPE);
        body.add("client_id", clientId);

        HttpEntity<?> request = new HttpEntity<>(body, httpHeaders);

        KakaoTokens response = restTemplate.postForObject(url, request, KakaoTokens.class);

        assert response != null;
        return response.getAccessToken();
    }


    @Override
    public OAuthInfoResponse requestOauthInfo(String accessToken) {

        String url = apiUrl + "/v2/user/me";

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        httpHeaders.set("Authorization", "Bearer " + accessToken);

        MultiValueMap<String, String> body = new LinkedMultiValueMap<>();
        body.add("property_keys", "[\"kakao_account.email\", \"kakao_account.gender\", \"kakao_account.profile\"]");

        HttpEntity<?> request = new HttpEntity<>(body, httpHeaders);

        return restTemplate.postForObject(url, request, OAuthInfoResponse.KakaoInfoResponse.class);
    }

    @Override
    public String searchMT1Nearby(double latitude, double longitude,String keyword) {
        String apiUrl = "https://dapi.kakao.com/v2/local/search/category.json";

        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "KakaoAK " + clientId);

        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(apiUrl)
                .queryParam("category_group_code", keyword) // MT1(대형마트) 카테고리 코드
                .queryParam("x", longitude)
                .queryParam("y", latitude);

        RequestEntity<?> requestEntity = new RequestEntity<>(headers, HttpMethod.GET, builder.build().toUri());
        ResponseEntity<String> responseEntity = new RestTemplate().exchange(requestEntity, String.class);

        if (responseEntity.getStatusCode().is2xxSuccessful()) {
            return responseEntity.getBody();
        } else {
            return "Error";
        }
    }

//    @Override
//    public void sendRequest() {
//        String requestUrl = "https://kapi.kakao.com/v1/user/ids";
//
//        HttpHeaders headers = new HttpHeaders();
//        headers.set("Authorization", clientId); // 실제 키로 대체
//
//        HttpEntity<?> requestEntity = new HttpEntity<>(headers);
//        ResponseEntity<String> responseEntity = restTemplate.exchange(
//                requestUrl,
//                HttpMethod.GET,
//                requestEntity,
//                String.class
//        );
//
//        if (responseEntity.getStatusCode() == HttpStatus.OK) {
//            String responseBody = responseEntity.getBody();
//            System.out.println("응답 내용: " + responseBody);
//        } else {
//            System.out.println("HTTP 요청 실패. 응답 코드: " + responseEntity.getStatusCodeValue());
//        }
//    }
}

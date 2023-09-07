package com.example.goormthon.config;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import java.net.InetSocketAddress;
import java.net.Proxy;

@Configuration
public class ClientConfig {

//    @Bean
//    public RestTemplate restTemplate() {
////
//////        @Value("${proxy.host}")
////        Proxy proxyHost = null;
//////        @Value("${proxy.port}")
////        Proxy proxyPort;
////        SimpleClientHttpRequestFactory factory = new SimpleClientHttpRequestFactory();
////        factory.setProxy(proxyHost);
////        factory.setProxy(proxyPort);
////        return new RestTemplate();
//
//    }
    @Bean
    public RestTemplate restTemplate() {
        String proxyHost = "krmp-proxy.9rum.cc";
        int proxyPort = 3128;

        SimpleClientHttpRequestFactory factory = new SimpleClientHttpRequestFactory();
        factory.setProxy(new Proxy(Proxy.Type.HTTP, new InetSocketAddress(proxyHost, proxyPort)));

        return new RestTemplate(factory);
    }
}

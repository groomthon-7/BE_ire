package com.example.goormthon.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ErrorCode {
    // 카카오API
    WRONG_ACCESS_TOKEN_AUTH("잘못된 인증입니다."),
    WRONG_AUTHORIZATION_HEADER("비정상적인 인증 헤더입니다."),
    EXPIRED_ACCESS_TOKEN("토큰이 만료되었습니다."),
    JWT_EXCEPTION("JWT 토큰 예외가 발생하였습니다."),
    ;

    private final String MESSAGE;
}

package com.tlea.geonneo.global.security.jwt;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class JwtValidateService {

    private final JwtTokenProvider jwtTokenProvider;

    public String getDongho(String token) {
        return jwtTokenProvider.extractAllClaims(token)
                .get("dongho", String.class);
    }
}

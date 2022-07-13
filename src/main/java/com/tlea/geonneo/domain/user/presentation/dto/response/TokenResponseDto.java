package com.tlea.geonneo.domain.user.presentation.dto.response;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class TokenResponseDto {

    private String accessToken;
}

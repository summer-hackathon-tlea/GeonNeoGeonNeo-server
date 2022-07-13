package com.tlea.geonneo.domain.with.presentation.dto.response;

import com.tlea.geonneo.domain.with.domain.With;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class WithResponse {

    private Long id;
    private String title;
    private String dongho;

    public static WithResponse of(With with) {
        return WithResponse.builder()
                .id(with.getId())
                .title(with.getTitle())
                .dongho(with.getUser().getDongho())
                .build();
    }
}

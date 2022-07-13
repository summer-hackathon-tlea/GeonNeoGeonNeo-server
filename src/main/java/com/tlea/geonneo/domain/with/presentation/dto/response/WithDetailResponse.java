package com.tlea.geonneo.domain.with.presentation.dto.response;

import com.tlea.geonneo.domain.with.domain.With;
import com.tlea.geonneo.domain.with.domain.type.Status;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class WithDetailResponse {

    private String title;
    private String content;
    private int maxNumberOfPeople;
    private Status status;
    private String dongho;

    public static WithDetailResponse of(With with) {
        return WithDetailResponse.builder()
                .title(with.getTitle())
                .content(with.getContent())
                .maxNumberOfPeople(with.getMaxNumberOfPeople())
                .status(with.getStatus())
                .dongho(with.getUser().getDongho())
                .build();
    }
}

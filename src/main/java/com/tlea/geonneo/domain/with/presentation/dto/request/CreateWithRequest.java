package com.tlea.geonneo.domain.with.presentation.dto.request;

import com.tlea.geonneo.domain.user.domain.User;
import com.tlea.geonneo.domain.with.domain.With;
import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.validation.constraints.NotNull;

@AllArgsConstructor
@Getter
public class CreateWithRequest {

    @NotNull
    private String title;

    @NotNull
    private String content;

    @NotNull
    private Integer maxNumberOfPeople;

    public With toEntity(User user) {
        return With.builder()
                .title(title)
                .content(content)
                .maxNumberOfPeople(maxNumberOfPeople)
                .user(user)
                .build();
    }
}

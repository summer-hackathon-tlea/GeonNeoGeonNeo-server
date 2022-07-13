package com.tlea.geonneo.domain.user.presentation.dto.request;

import com.sun.istack.NotNull;
import com.tlea.geonneo.domain.user.domain.User;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class UserRequestDto {

    @NotNull
    private String dongho;

    @NotNull
    private String password;

    public User toEntity(String password) {
        return User.builder()
                .dongho(dongho)
                .password(password)
                .build();
    }
}

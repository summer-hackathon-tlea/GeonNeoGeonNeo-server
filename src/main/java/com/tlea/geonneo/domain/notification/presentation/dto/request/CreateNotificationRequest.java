package com.tlea.geonneo.domain.notification.presentation.dto.request;

import com.tlea.geonneo.domain.notification.domain.Notification;
import com.tlea.geonneo.domain.user.domain.User;
import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.stream.Collectors;

@Builder
@Getter
public class CreateNotificationRequest {

    @NotNull
    private String sendDongho;

    @NotNull
    private String content;

    @NotNull
    private List<User> user;

    public List<Notification> toEntity() {
        return user.stream()
                .map(u -> Notification.builder()
                        .sendDongho(sendDongho)
                        .content(content)
                        .user(u)
                        .build()
                )
                .collect(Collectors.toList());
    }
}

package com.tlea.geonneo.domain.notification.presentation.dto.response;

import com.tlea.geonneo.domain.notification.domain.Notification;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class NotificationResponse {

    private Long id;
    private Long withId;
    private String sendDongho;
    private String content;
    private boolean isRead;

    public static NotificationResponse of(Notification notification) {
        return NotificationResponse.builder()
                .id(notification.getId())
                .withId(notification.getWith().getId())
                .sendDongho(notification.getSendDongho())
                .content(notification.getContent())
                .isRead(notification.getIsRead())
                .build();
    }
}

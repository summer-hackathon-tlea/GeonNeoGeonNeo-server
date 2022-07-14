package com.tlea.geonneo.domain.notification.facade;

import com.tlea.geonneo.domain.notification.domain.Notification;
import com.tlea.geonneo.domain.notification.domain.repository.NotificationRepository;
import com.tlea.geonneo.domain.notification.exception.NotificationNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class NotificationFacade {

    private final NotificationRepository notificationRepository;

    public Notification findNotificationById(Long id) {
        return notificationRepository.findById(id)
                .orElseThrow(() -> NotificationNotFoundException.EXCEPTION);
    }
}

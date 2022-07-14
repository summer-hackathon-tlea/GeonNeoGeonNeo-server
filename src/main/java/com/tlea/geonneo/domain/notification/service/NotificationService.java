package com.tlea.geonneo.domain.notification.service;

import com.tlea.geonneo.domain.notification.domain.Notification;
import com.tlea.geonneo.domain.notification.domain.repository.NotificationRepository;
import com.tlea.geonneo.domain.notification.facade.NotificationFacade;
import com.tlea.geonneo.domain.notification.presentation.dto.request.CreateNotificationRequest;
import com.tlea.geonneo.domain.notification.presentation.dto.response.NotificationResponse;
import com.tlea.geonneo.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class NotificationService {

    private final NotificationRepository notificationRepository;
    private final NotificationFacade notificationFacade;
    private final UserFacade userFacade;

    public void createNotification(CreateNotificationRequest request) {
        notificationRepository.saveAll(request.toEntity());
    }

    @Transactional(readOnly = true)
    public List<NotificationResponse> getAllUserNotification() {
        return userFacade.getCurrentUser().getNotifications()
                .stream().map(NotificationResponse::of)
                .collect(Collectors.toList());
    }

    @Transactional
    public void readNotification(Long notificationId) {
        Notification notification = notificationFacade.findNotificationById(notificationId);
        notification.read();
    }
}

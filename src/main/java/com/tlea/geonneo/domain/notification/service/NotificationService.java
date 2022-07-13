package com.tlea.geonneo.domain.notification.service;

import com.tlea.geonneo.domain.notification.domain.repository.NotificationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class NotificationService {

    private final NotificationRepository notificationRepository;


}

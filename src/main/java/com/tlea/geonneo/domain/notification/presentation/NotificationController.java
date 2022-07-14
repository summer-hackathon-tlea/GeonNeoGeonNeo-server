package com.tlea.geonneo.domain.notification.presentation;

import com.tlea.geonneo.domain.notification.presentation.dto.response.NotificationResponse;
import com.tlea.geonneo.domain.notification.service.NotificationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/notification")
@RequiredArgsConstructor
public class NotificationController {

    private final NotificationService notificationService;

    @GetMapping
    public List<NotificationResponse> getAllUserNotification() {
        return notificationService.getAllUserNotification();
    }
}

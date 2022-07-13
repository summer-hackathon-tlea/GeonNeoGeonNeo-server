package com.tlea.geonneo.domain.notification.domain.repository;

import com.tlea.geonneo.domain.notification.domain.Notification;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotificationRepository extends JpaRepository<Notification, Long> {
}

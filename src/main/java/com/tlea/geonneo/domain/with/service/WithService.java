package com.tlea.geonneo.domain.with.service;

import com.tlea.geonneo.domain.notification.presentation.dto.request.CreateNotificationRequest;
import com.tlea.geonneo.domain.notification.service.NotificationService;
import com.tlea.geonneo.domain.user.domain.User;
import com.tlea.geonneo.domain.user.facade.UserFacade;
import com.tlea.geonneo.domain.with.domain.With;
import com.tlea.geonneo.domain.with.domain.repository.WithRepository;
import com.tlea.geonneo.domain.with.domain.type.Authority;
import com.tlea.geonneo.domain.with.domain.type.Status;
import com.tlea.geonneo.domain.with.facade.WithFacade;
import com.tlea.geonneo.domain.with.facade.WitherFacade;
import com.tlea.geonneo.domain.with.presentation.dto.request.CreateWithRequest;
import com.tlea.geonneo.domain.with.presentation.dto.response.WithDetailResponse;
import com.tlea.geonneo.domain.with.presentation.dto.response.WithResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class WithService {

    private final WithRepository withRepository;
    private final WithFacade withFacade;
    private final UserFacade userFacade;
    private final WitherService witherService;
    private final NotificationService notificationService;
    private final WitherFacade witherFacade;

    @Transactional(readOnly = true)
    public List<WithResponse> getAllWiths() {
        return withRepository.findAll()
                .stream().map(WithResponse::of)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public WithDetailResponse getWithDetail(Long withId) {
        return WithDetailResponse.of(
                withFacade.findWithById(withId));
    }

    @Transactional
    public void createWith(CreateWithRequest request) {
        User user = userFacade.getCurrentUser();
        With with = withRepository.save(request.toEntity(user));
        witherService.joinWith(with, user);
        notificationService.createNotification(
                CreateNotificationRequest.builder()
                        .sendDongho(user.getDongho())
                        .content(with.getTitle())
                        .user(userFacade.getAllUserWithoutUser(user))
                        .build()
        );
    }

    @Transactional
    public void updateWithStatus(Long withId, Status status) {
        With with = withFacade.findWithById(withId);
        witherFacade.checkWitherPermission(
                with, userFacade.getCurrentUser(), Authority.LEADER);
        with.updateWithStatus(status);
    }
}

package com.tlea.geonneo.domain.with.service;

import com.tlea.geonneo.domain.user.facade.UserFacade;
import com.tlea.geonneo.domain.with.domain.repository.WithRepository;
import com.tlea.geonneo.domain.with.presentation.dto.request.CreateWithRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class WithService {

    private final WithRepository withRepository;
    private final UserFacade userFacade;

    @Transactional
    public void createWith(CreateWithRequest request) {
        withRepository.save(request.toEntity(userFacade.getCurrentUser()));
    }
}

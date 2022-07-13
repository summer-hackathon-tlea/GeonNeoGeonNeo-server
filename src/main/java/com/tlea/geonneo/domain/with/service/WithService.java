package com.tlea.geonneo.domain.with.service;

import com.tlea.geonneo.domain.user.facade.UserFacade;
import com.tlea.geonneo.domain.with.domain.repository.WithRepository;
import com.tlea.geonneo.domain.with.facade.WithFacade;
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
        withRepository.save(request.toEntity(userFacade.getCurrentUser()));
    }
}

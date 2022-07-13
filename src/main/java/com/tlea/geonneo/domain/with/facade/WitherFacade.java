package com.tlea.geonneo.domain.with.facade;

import com.tlea.geonneo.domain.user.domain.User;
import com.tlea.geonneo.domain.with.domain.With;
import com.tlea.geonneo.domain.with.domain.repository.WitherRepository;
import com.tlea.geonneo.domain.with.exception.WitherAlreadyExistsException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class WitherFacade {

    private final WitherRepository witherRepository;

    public void checkWither(With with, User user) {
        if (witherRepository.existsByWithAndUser(with, user)) {
            throw WitherAlreadyExistsException.EXCEPTION;
        }
    }
}

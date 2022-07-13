package com.tlea.geonneo.domain.with.facade;

import com.tlea.geonneo.domain.with.domain.With;
import com.tlea.geonneo.domain.with.domain.repository.WithRepository;
import com.tlea.geonneo.domain.with.exception.FullWithException;
import com.tlea.geonneo.domain.with.exception.WithNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class WithFacade {

    private final WithRepository withRepository;

    public With findWithById(Long withId) {
        return withRepository.findById(withId)
                .orElseThrow(() -> WithNotFoundException.EXCEPTION);
    }

    public void checkNumberOfWither(With with) {
        if (with.getWithers().size() == with.getMaxNumberOfPeople()) {
            throw FullWithException.EXCEPTION;
        }
    }
}
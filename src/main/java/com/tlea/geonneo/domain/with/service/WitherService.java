package com.tlea.geonneo.domain.with.service;

import com.tlea.geonneo.domain.user.domain.User;
import com.tlea.geonneo.domain.user.facade.UserFacade;
import com.tlea.geonneo.domain.with.domain.With;
import com.tlea.geonneo.domain.with.domain.Wither;
import com.tlea.geonneo.domain.with.domain.repository.WitherRepository;
import com.tlea.geonneo.domain.with.domain.type.Authority;
import com.tlea.geonneo.domain.with.facade.WithFacade;
import com.tlea.geonneo.domain.with.facade.WitherFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class WitherService {

    private final WitherRepository witherRepository;
    private final WithFacade withFacade;
    private final UserFacade userFacade;
    private final WitherFacade witherFacade;

    @Transactional
    public void joinWith(Long withId) {
        With with = withFacade.findWithById(withId);
        User user = userFacade.getCurrentUser();
        witherFacade.checkWither(with, user);
        withFacade.checkNumberOfWither(with);

        witherRepository.save(
                Wither.builder()
                        .with(with)
                        .user(user)
                        .authority(Authority.MEMBER)
                        .build()
        );
    }

    public void joinWith(With with, User user) {
        witherRepository.save(
                Wither.builder()
                        .with(with)
                        .user(user)
                        .authority(Authority.LEADER)
                        .build()
        );
    }
}

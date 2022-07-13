package com.tlea.geonneo.domain.user.service;

import com.tlea.geonneo.domain.user.domain.User;
import com.tlea.geonneo.domain.user.domain.repository.UserRepository;
import com.tlea.geonneo.domain.user.facade.UserFacade;
import com.tlea.geonneo.domain.user.presentation.dto.response.TokenResponseDto;
import com.tlea.geonneo.domain.user.presentation.dto.request.UserRequestDto;
import com.tlea.geonneo.global.security.jwt.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final UserFacade userFacade;
    private final PasswordEncoder passwordEncoder;
    private final JwtTokenProvider jwtTokenProvider;

    @Transactional
    public void joinUser(UserRequestDto request) {
        userFacade.checkUserByDongho(request.getDongho());
        userRepository.save(request.toEntity(passwordEncoder.encode(request.getPassword())));
    }

    @Transactional
    public TokenResponseDto loginUser(UserRequestDto request) {
        User user = userFacade.findUserByDongho(request.getDongho());
        userFacade.checkUserPassword(user, request.getPassword());

        final String accessToken = jwtTokenProvider.createToken(request.getDongho());

        return TokenResponseDto.builder()
                .accessToken(accessToken)
                .build();
    }
}

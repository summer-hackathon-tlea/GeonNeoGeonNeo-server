package com.tlea.geonneo.domain.user.presentation;

import com.tlea.geonneo.domain.user.presentation.dto.request.UserRequestDto;
import com.tlea.geonneo.domain.user.presentation.dto.response.TokenResponseDto;
import com.tlea.geonneo.domain.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/join")
    public void joinUser(@RequestBody @Valid UserRequestDto request) {
        userService.joinUser(request);
    }

    @PostMapping("/login")
    public TokenResponseDto loginUser(@RequestBody @Valid UserRequestDto request) {
        return userService.loginUser(request);
    }
}

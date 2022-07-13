package com.tlea.geonneo.domain.with.presentation;

import com.tlea.geonneo.domain.with.service.WitherService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/with/{withId}")
@RequiredArgsConstructor
public class WitherController {

    private final WitherService witherService;

    @PostMapping("/member")
    public void joinWith(@PathVariable Long withId) {
        witherService.joinWith(withId);
    }
}

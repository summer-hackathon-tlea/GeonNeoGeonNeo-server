package com.tlea.geonneo.domain.with.presentation;

import com.tlea.geonneo.domain.with.service.WitherService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

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

package com.tlea.geonneo.domain.with.presentation;

import com.tlea.geonneo.domain.with.presentation.dto.request.CreateWithRequest;
import com.tlea.geonneo.domain.with.service.WithService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/with")
@RequiredArgsConstructor
public class WithController {

    private final WithService withService;

    @PostMapping
    public void createWith(@RequestBody @Valid CreateWithRequest request) {
        withService.createWith(request);
    }
}

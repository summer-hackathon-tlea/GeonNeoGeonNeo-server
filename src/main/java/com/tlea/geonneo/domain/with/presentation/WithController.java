package com.tlea.geonneo.domain.with.presentation;

import com.tlea.geonneo.domain.with.presentation.dto.request.CreateWithRequest;
import com.tlea.geonneo.domain.with.presentation.dto.response.WithResponse;
import com.tlea.geonneo.domain.with.service.WithService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/with")
@RequiredArgsConstructor
public class WithController {

    private final WithService withService;

    @GetMapping
    public List<WithResponse> getAllWiths() {
        return withService.getAllWiths();
    }

    @PostMapping
    public void createWith(@RequestBody @Valid CreateWithRequest request) {
        withService.createWith(request);
    }
}
package org.cybersoft.bookingticketcinemabe.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.cybersoft.bookingticketcinemabe.payload.request.authentication.AuthenticateRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/auth")
@Tag(name = "Authentication", description = "APIs for user authentication and authorization")
public interface AuthenticationController {
    @PostMapping("/login")
    ResponseEntity<?> Authenticate(@RequestBody @Valid AuthenticateRequest request);
}

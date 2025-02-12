package org.cybersoft.bookingticketcinemabe.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.cybersoft.bookingticketcinemabe.payload.request.user.ProfileUpdateRequest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RequestMapping("/profile/me")
@Tag(name = "Profile", description = "APIs for managing user profiles and personal information")
public interface ProfileController {

    @GetMapping
    ResponseEntity<?> getUser(@RequestHeader HttpHeaders header);

    @PutMapping
    ResponseEntity<?> updateUser(@RequestHeader HttpHeaders header, @RequestBody @Valid ProfileUpdateRequest request);

}

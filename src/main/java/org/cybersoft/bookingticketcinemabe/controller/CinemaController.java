package org.cybersoft.bookingticketcinemabe.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.cybersoft.bookingticketcinemabe.payload.request.cinema.CinemaCreationRequest;
import org.cybersoft.bookingticketcinemabe.payload.request.cinema.CinemaCriteria;
import org.cybersoft.bookingticketcinemabe.payload.request.cinema.CinemaUpdateRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping
@Tag(name = "Cinema", description = "APIs for managing cinema information")
public interface CinemaController {
    @GetMapping("/cinemas")
    ResponseEntity<?> getCinemas(CinemaCriteria cinemaCriteria);

    @GetMapping("/cinema/{id}")
    ResponseEntity<?> getCinema(@PathVariable int id);

    @PostMapping("/cinema")
    ResponseEntity<?> createCinema(@RequestBody @Valid CinemaCreationRequest cinemaCreationRequest);

    @PatchMapping("/cinema/{id}")
    ResponseEntity<?> updateCinema(@PathVariable Integer id, @RequestBody @Valid CinemaUpdateRequest cinemaUpdateRequest);

    @DeleteMapping("/cinema/{id}")
    ResponseEntity<?> deleteCinema(@PathVariable Integer id);
}

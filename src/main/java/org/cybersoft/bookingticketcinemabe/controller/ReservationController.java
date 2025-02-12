package org.cybersoft.bookingticketcinemabe.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.cybersoft.bookingticketcinemabe.dto.ReservationDTO;
import org.cybersoft.bookingticketcinemabe.payload.request.reservation.ReservationBookingRequest;
import org.cybersoft.bookingticketcinemabe.payload.response.BaseResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping
@Tag(name = "Reservation", description = "APIs for managing movie ticket reservations")
public interface ReservationController {
    @PostMapping("/booking/{screeningId}")
    ResponseEntity<BaseResponse<ReservationDTO>> bookingTicket(@PathVariable("screeningId") Integer screeningId,
                                                               @RequestBody @Valid ReservationBookingRequest reservationBookingRequest);

    @DeleteMapping("/booking/{screeningId}/{reservationId}")
    ResponseEntity<BaseResponse<ReservationDTO>> cancelBooking(@PathVariable("screeningId") Integer screeningId,
                                                               @PathVariable("reservationId") Integer reservationId);
}

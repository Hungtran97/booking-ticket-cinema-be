package org.cybersoft.bookingticketcinemabe.payload.request.user;

import lombok.Builder;

@Builder
public record UserUpdateRequest(
        String phone,
        String role,
        String firstName,
        String lastName,
        String fullName,
        String avatar,
        String password
) {
}
package org.cybersoft.bookingticketcinemabe.payload.request.authentication;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;

@Schema(description = "Authenticate user and return JWT token")
public record AuthenticateRequest(
        @Schema(
                description = "The email address of the user",
                example = "user@example.com",
                requiredMode = Schema.RequiredMode.REQUIRED
        )
        @Email(message = "The email address is invalid and cannot be authenticated")
        @NotEmpty(message = "Email is required")
        String email,

        @Schema(
                description = "The password of the user",
                example = "your_password",
                requiredMode = Schema.RequiredMode.REQUIRED
        )
        @NotEmpty(message = "This field is not empty")
        String password
) {
}

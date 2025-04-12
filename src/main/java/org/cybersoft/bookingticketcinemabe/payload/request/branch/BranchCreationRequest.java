package org.cybersoft.bookingticketcinemabe.payload.request.branch;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;
import java.util.List;

@Schema(description = "Request payload for creating a new cinema branch")
public record BranchCreationRequest(
        @Schema(
                description = "Name of the branch",
                example = "Cinema City Central"
        )
        String name,
        @Schema(
                description = "URL of the branch logo image",
                example = "https://example.com/logos/cinema-central.png",
                pattern = "^(https?|ftp)://[^\\s/$.?#].[^\\s]*$"
        )
        String logo,
        @Schema(
                description = "URL of the branch avatar image",
                example = "https://example.com/avatars/cinema-central-avatar.jpg",
                pattern = "^(https?|ftp)://[^\\s/$.?#].[^\\s]*$"
        )
        String avatar,
        @Schema(
                description = "Website link for the branch",
                example = "https://cinemacentral.example.com",
                pattern = "^(https?|ftp)://[^\\s/$.?#].[^\\s]*$"
        )
        String link,

        @Schema(
                description = "Physical address of the branch",
                example = "123 Cinema Street, District 1"
        )
        String address,
        @Schema(
                description = "ID of the district where the branch is located",
                example = "1"
        )
        Integer districtId,
        @Schema(
                description = "ID of the parent cinema",
                example = "1"
        )
        Integer cinemaId,
        @Schema(
                description = "List of movie IDs available at this branch. See the Movie list.",
                example = "[1, 2, 3]"
        )
        List<Integer> movieIds,
        @Positive(message = "The distance must be positive")
        @Schema(
                description = "Distance from city center in kilometers",
                example = "2.5"
        )
        BigDecimal distance,

        @Min(value = -90, message = "Latitude must be greater than or equal to -90")
        @Max(value = 90, message = "Latitude must be less than or equal to 90")
        @Schema(
                description = "Latitude coordinate of the branch location",
                example = "10.823099",
                minimum = "-90",
                maximum = "90"
        )
        BigDecimal lat,
        @Min(value = -90, message = "Longitude must be greater than or equal to -90")
        @Max(value = 90, message = "Longitude must be less than or equal to 90")
        @Schema(
                description = "Longitude coordinate of the branch location",
                example = "106.629662",
                minimum = "-180",
                maximum = "180"
        )
        BigDecimal lon,
        @Schema(
                description = "Average rating of the branch (0-5 scale)",
                example = "4.5",
                minimum = "0",
                maximum = "5"
        )
        BigDecimal rating,
        @Schema(
                description = "Number of halls that will be automatically created when creating this branch (optional)",
                example = "1",
                minimum = "1",
                maximum = "10",
                requiredMode = Schema.RequiredMode.NOT_REQUIRED
        )
        @Positive(message = "Must be positive if provided")
        @Max(value = 10, message = "Cannot have more than 10 halls")
        Integer totalCineplexHall) {
}

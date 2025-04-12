package org.cybersoft.bookingticketcinemabe.payload.request.pagination;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.cybersoft.bookingticketcinemabe.query.enums.Order;

import java.time.LocalDateTime;

@Data
@Schema(description = "Pagination and filtering parameters for API requests")
public class Pagination {

    @Schema(
            description = "Page number to retrieve (1-based indexing)",
            example = "1",
            minimum = "1",
            defaultValue = "1"
    )
    private Integer pageNo = 1;

    @Schema(
            description = "Maximum number of items per page",
            example = "10",
            minimum = "1",
            maximum = "100",
            defaultValue = "10"
    )
    private Integer pageLimit = 10;

    @Schema(
            description = "Field to sort by",
            example = "id",
            defaultValue = "id"
    )
    private String sort = "id";

    @Schema(
            description = "Sorting order",
            example = "ASC",
            allowableValues = {"ASC", "DESC"},
            defaultValue = "ASC"
    )
    private Order order = Order.ASC;

    @Schema(
            description = "Filter records created after this timestamp (inclusive)",
            example = "1970-01-01T00:00:00",
            type = "string",
            format = "date-time"
    )
    private LocalDateTime createdAtFrom;

    @Schema(
            description = "Filter records created before this timestamp (inclusive)",
            example = "NOW",
            type = "string",
            format = "date-time"
    )
    private LocalDateTime createdAtTo;

    @Schema(
            description = "Filter records updated after this timestamp (inclusive)",
            example = "1970-01-01T00:00:00",
            type = "string",
            format = "date-time"
    )
    private LocalDateTime updatedAtFrom;

    @Schema(
            description = "Filter records updated before this timestamp (inclusive)",
            example = "NOW",
            type = "string",
            format = "date-time"
    )
    private LocalDateTime updatedAtTo;
}

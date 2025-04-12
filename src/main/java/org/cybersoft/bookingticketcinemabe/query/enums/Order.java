package org.cybersoft.bookingticketcinemabe.query.enums;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Sorting direction")
public enum Order {
    @Schema(description = "Ascending order")
    ASC,

    @Schema(description = "Descending order")
    DESC
}

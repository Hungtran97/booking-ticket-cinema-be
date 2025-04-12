package org.cybersoft.bookingticketcinemabe.payload.request.branch;

import io.swagger.v3.oas.annotations.extensions.Extension;
import io.swagger.v3.oas.annotations.extensions.ExtensionProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.cybersoft.bookingticketcinemabe.payload.request.pagination.Pagination;

import java.math.BigDecimal;

@EqualsAndHashCode(callSuper = true)
@Data
@Schema(description = "Criteria for filtering and searching branches",
        requiredMode = Schema.RequiredMode.AUTO)
public class BranchCriteria extends Pagination {

    @Schema(
            description = "Filter by branch ID",
            example = "1"
    )
    private Integer id;

    @Schema(
            description = "Filter by branch name (case-insensitive partial match)",
            example = "Downtown Cinema"
    )
    private String name;

    @Schema(
            description = "Filter by distance from reference point (in kilometers)",
            example = "5.2",
            minimum = "0",
            implementation = Double.class,
            extensions = {
                    @Extension(name = "x-unit", properties = {
                            @ExtensionProperty(name = "value", value = "km"),
                            @ExtensionProperty(name = "description", value = "kilometers")
                    })
            }
    )
    private BigDecimal distance;

    @Schema(
            description = "Filter by minimum rating score",
            example = "4.5",
            minimum = "0",
            maximum = "5"
    )
    private BigDecimal rating;

    @Schema(
            description = "Filter by address (case-insensitive partial match). " +
                    "Can search by street, district or city.",
            example = "Main St",
            pattern = "^[a-zA-Z0-9\\s,.-]*$"
    )
    private String address;
}

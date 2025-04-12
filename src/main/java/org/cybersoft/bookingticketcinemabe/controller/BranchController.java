package org.cybersoft.bookingticketcinemabe.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.cybersoft.bookingticketcinemabe.payload.request.branch.BranchCreationRequest;
import org.cybersoft.bookingticketcinemabe.payload.request.branch.BranchCriteria;
import org.cybersoft.bookingticketcinemabe.payload.request.branch.BranchUpdateRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping
@Tag(name = "Branch", description = "APIs for managing branch information of cinemas")
public interface BranchController {

    @Operation(
            summary = "Get all branches",
            description = "Retrieve a list of branches based on filtering criteria"
    )
    @GetMapping("/branches")
    ResponseEntity<?> getBranches(@Parameter BranchCriteria branchCriteria);

    @Operation(
            summary = "Get branch by ID",
            description = "Retrieve detailed information about a specific branch",
            parameters = {
                    @Parameter(name = "id", description = "ID of the branch to retrieve")
            }
    )
    @GetMapping("/branch/{id}")
    ResponseEntity<?> getBranch(@PathVariable Integer id);

    @Operation(
            summary = "Create new branch",
            description = "Add a new branch to the system",
            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    description = "Branch creation request payload"
            )
    )
    @PostMapping("/branch")
    ResponseEntity<?> createBranch(@RequestBody @Valid BranchCreationRequest request);

    @Operation(
            summary = "Update branch",
            description = "Update information of an existing branch",
            parameters = {
                    @Parameter(name = "id", description = "ID of the branch to update")
            },
            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    description = "Branch update request payload"
            )
    )
    @PutMapping("/branch/{id}")
    ResponseEntity<?> updateBranch(@PathVariable Integer id, @RequestBody @Valid BranchUpdateRequest request);

    @Operation(
            summary = "Delete branch",
            description = "Remove a branch from the system",
            parameters = {
                    @Parameter(name = "id", description = "ID of the branch to delete")
            }
    )
    @DeleteMapping("/branch/{id}")
    ResponseEntity<?> deleteBranch(@PathVariable Integer id);
}
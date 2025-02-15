package org.cybersoft.bookingticketcinemabe.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RequestMapping()
@Tag(name = "District", description = "APIs for managing district information")
public interface DistrictController {
    @GetMapping("/districts")
    ResponseEntity<?> getDistricts(@RequestParam(defaultValue = "0") int pageNo,
                                   @RequestParam(defaultValue = "10") int pageLimit,
                                   @RequestParam(defaultValue = "id") String sortBy,
                                   Integer provinceId);


    @GetMapping("/district/{id}")
    ResponseEntity<?> getDistrict(@PathVariable Integer id);


}

package org.cybersoft.bookingticketcinemabe.controller;

import jakarta.validation.Valid;
import org.cybersoft.bookingticketcinemabe.payload.request.user.UserCreationRequest;
import org.cybersoft.bookingticketcinemabe.payload.request.user.UserUpdateRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RequestMapping()
public interface UserController {
    @GetMapping("/users")
    ResponseEntity<?> getUsers(@RequestParam(defaultValue = "0") int pageNo,
                               @RequestParam(defaultValue = "10") int pageLimit,
                               @RequestParam(defaultValue = "id") String sortBy);

    @GetMapping("/user/{id}")
    ResponseEntity<?> getUser(@PathVariable int id);

    @PostMapping("/user")
    ResponseEntity<?> createUser(@RequestBody @Valid UserCreationRequest request);

    @PutMapping("/user/{id}")
    ResponseEntity<?> updateUser(@RequestBody UserUpdateRequest request, @PathVariable Integer id);

    @DeleteMapping("/user/{id}")
    ResponseEntity<?> deleteUser(@PathVariable int id);

}

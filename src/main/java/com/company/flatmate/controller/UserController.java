package com.company.flatmate.controller;

import com.company.flatmate.dto.UserDto;
import com.company.flatmate.exception.NoSuchDataException;
import com.company.flatmate.security.payload.MessageResponse;
import com.company.flatmate.service.UserService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.NoSuchElementException;
import java.util.UUID;

@RestController
@RequestMapping("/user")
@SecurityRequirement(name = "flatmateapi")
@AllArgsConstructor
@CrossOrigin
public class UserController {

    private final UserService service;

    @GetMapping("/{id}")
    public ResponseEntity<?> getUserById(@PathVariable String id) {
        return ResponseEntity.ok(service.findById(UUID.fromString(id)));
    }

    @GetMapping(params="login")
    public ResponseEntity<?> getUserByLogin(@RequestParam(value = "login") String login) {
        return ResponseEntity.ok(service.findByLogin(login));
    }

    @PostMapping
    public ResponseEntity<?> addUser(@RequestBody UserDto user) {
        service.save(user);
        return ResponseEntity.ok().build();
    }

}
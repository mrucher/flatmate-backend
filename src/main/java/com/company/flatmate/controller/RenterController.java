package com.company.flatmate.controller;

import com.company.flatmate.dto.RenterDto;
import com.company.flatmate.exception.NoSuchDataException;
import com.company.flatmate.security.payload.MessageResponse;
import com.company.flatmate.service.RenterService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.AllArgsConstructor;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.NoSuchElementException;
import java.util.UUID;

@RestController
@SecurityRequirement(name = "flatmateapi")
@RequestMapping("/renter")
@AllArgsConstructor
@CrossOrigin
public class RenterController {

    private final RenterService service;

    @GetMapping()
    public ResponseEntity<?> getActiveRenters() {
        return ResponseEntity.ok(service.findAllByActive(true));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getRenter(@PathVariable String id) {
        return ResponseEntity.ok(service.findById(UUID.fromString(id)));
    }

    @GetMapping(params = {"min", "max"})
    public ResponseEntity<?> getRenterByMaxPrice(@RequestParam(value = "min") double min,
                                                  @RequestParam(value = "max") double max) {
        return ResponseEntity.ok(service.findAllByMaxPriceBetween(min, max));
    }

    @PostMapping
    public ResponseEntity<?> addRenter(@RequestBody RenterDto renter) {
        service.save(renter);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteApartment(@PathVariable String id) {
        service.deleteById(UUID.fromString(id));
        return ResponseEntity.ok().build();
    }
}
package com.company.flatmate.controller;

import com.company.flatmate.dto.ApartmentDto;
import com.company.flatmate.exception.NoSuchDataException;
import com.company.flatmate.security.payload.MessageResponse;
import com.company.flatmate.service.ApartmentService;
import com.company.flatmate.util.mapper.ApartmentFeedbackMapper;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.AllArgsConstructor;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.OffsetDateTime;
import java.util.*;

@RestController
@RequestMapping("/apartment")
@SecurityRequirement(name = "flatmateapi")
@AllArgsConstructor
@CrossOrigin
public class ApartmentController {

    private final ApartmentService service;


    @GetMapping("/{id}")
    public ResponseEntity<?> getActiveApartments(@PathVariable String id) {
            return ResponseEntity.ok(service.findById(UUID.fromString(id)));
    }

    @GetMapping
    public ResponseEntity<?> getActiveApartments() {
        List<ApartmentDto> list = service.findAllByActive(true);
        return ResponseEntity.ok(list);
    }

    @GetMapping(params = {"min", "max"})
    public ResponseEntity<?> getApartmentsByPrice(@RequestParam(value = "min") double min,
                                                  @RequestParam(value = "max") double max) {
        List<ApartmentDto> list = service.findAllByPriceBetween(min, max);
        return ResponseEntity.ok(list);
    }

    @GetMapping(params = "count_room")
    public ResponseEntity<?> getApartmentsByRooms(@RequestParam(value = "count_room") int count) {
        List<ApartmentDto> list = service.findAllByRoomsCount(count);
        return ResponseEntity.ok(list);
    }

    @GetMapping(params = "count_lodger")
    public ResponseEntity<?> getApartmentsByLodgers(@RequestParam(value = "count_lodger") int count) {
        List<ApartmentDto> list = service.findAllByLodgerCount(count);
        return ResponseEntity.ok(list);
    }

    @PostMapping
    public ResponseEntity<?> addApartment(@RequestBody ApartmentDto apartment) {
        UUID id = service.save(apartment);
        return ResponseEntity.ok(Collections.singletonMap("id", id));
    }

    @DeleteMapping(params = "date")
    public ResponseEntity<?> deleteOutdatedApartments(@RequestParam("date") OffsetDateTime date) {
        service.deleteAllByDateBefore(date);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteApartment(@PathVariable String id) {
        service.deleteById(UUID.fromString(id));
        return ResponseEntity.ok().build();
    }

    @DeleteMapping
    public ResponseEntity<?> deleteNotActiveApartments() {
        service.deleteAllByActive(false);
        return ResponseEntity.ok().build();
    }
}

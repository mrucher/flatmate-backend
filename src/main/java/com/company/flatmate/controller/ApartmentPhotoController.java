package com.company.flatmate.controller;

import com.company.flatmate.dto.ApartmentPhotoDto;
import com.company.flatmate.exception.NoSuchDataException;
import com.company.flatmate.security.payload.MessageResponse;
import com.company.flatmate.service.ApartmentPhotoService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.AllArgsConstructor;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/apartment/photo")
@SecurityRequirement(name = "flatmateapi")
@AllArgsConstructor
@CrossOrigin
public class ApartmentPhotoController {

    private final ApartmentPhotoService service;

    @GetMapping(params = "apart_id")
    public ResponseEntity<?> getApartmentPhotos(@RequestParam("apart_id") String id) {
        List<ApartmentPhotoDto> list = service.findAllByApartmentId(UUID.fromString(id));
        return ResponseEntity.ok(list);
    }

    @PostMapping
    public ResponseEntity<?> addApartmentPhoto(@RequestBody ApartmentPhotoDto photo) {
        service.save(photo);
        return ResponseEntity.ok().build();
    }
}

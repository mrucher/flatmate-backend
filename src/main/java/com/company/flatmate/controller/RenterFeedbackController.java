package com.company.flatmate.controller;

import com.company.flatmate.dto.ApartmentFeedbackDto;
import com.company.flatmate.dto.RenterFeedbackDto;
import com.company.flatmate.entity.RenterFeedback;
import com.company.flatmate.exception.NoSuchDataException;
import com.company.flatmate.security.payload.MessageResponse;
import com.company.flatmate.service.RenterFeedbackService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@SecurityRequirement(name = "flatmateapi")
@RequestMapping("/renter/feedback")
@AllArgsConstructor
@CrossOrigin
public class RenterFeedbackController {

    private final RenterFeedbackService service;

    @GetMapping(params = "renterId")
    public ResponseEntity<?> getRenterFeedbacks(@RequestParam("renterId") String id) {
        List<RenterFeedbackDto> list = service.findAllByRenterId(UUID.fromString(id));
        return ResponseEntity.ok(list);
    }

    @PostMapping
    public ResponseEntity<?> addRenterFeedback(@RequestBody RenterFeedbackDto renterFeedback) {
        service.save(renterFeedback);
        return ResponseEntity.ok().build();
    }

}
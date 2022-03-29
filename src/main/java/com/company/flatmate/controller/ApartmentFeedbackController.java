package com.company.flatmate.controller;

import com.company.flatmate.dto.ApartmentFeedbackDto;
import com.company.flatmate.exception.NoSuchDataException;
import com.company.flatmate.security.payload.MessageResponse;
import com.company.flatmate.service.ApartmentFeedbackService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.AllArgsConstructor;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/apartment/feedback")
@SecurityRequirement(name = "flatmateapi")
@AllArgsConstructor
@CrossOrigin
public class ApartmentFeedbackController {

    private final ApartmentFeedbackService service;

    @GetMapping(params = "apartId")
    public ResponseEntity<?> getApartmentFeedbacks(@RequestParam("apartId") String id) {
        List<ApartmentFeedbackDto> list = service.findAllByApartmentId(UUID.fromString(id));
        return ResponseEntity.ok(list);
    }

//    @GetMapping(params = "author_id")
//    public ResponseEntity<?> getApartmentFeedbacksByAuthor(@RequestParam("author_id") String id) {
//        try {
//            List<ApartmentFeedbackDto> list = service.findAllByAuthorId(UUID.fromString(id));
//            return ResponseEntity.ok(list);
//        } catch (IllegalArgumentException e) {
//            return ResponseEntity
//                    .badRequest()
//                    .body(new MessageResponse("Apartment ID is entered incorrectly!"));
//        } catch (EmptyResultDataAccessException e) {
//            return ResponseEntity
//                    .notFound().build();
//        }
//    }

    @PostMapping
    public ResponseEntity<?> addApartmentFeedback(@RequestBody ApartmentFeedbackDto feedback) {
        service.save(feedback);
        return ResponseEntity.ok().build();
    }
}

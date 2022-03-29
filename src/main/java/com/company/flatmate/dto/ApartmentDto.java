package com.company.flatmate.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.geo.Point;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.UUID;

@Data
@NoArgsConstructor
public class ApartmentDto {
    private UUID id;

    private Integer roomsCount;

    private Integer lodgerCount;

    private String address;

    private Point location;

    private List<ApartmentPhotoDto> photos;

    private List<ApartmentFeedbackDto> feedbacks;

    private List<RenterDto> renters;

    private Double price;

    private OffsetDateTime publicationDate = OffsetDateTime.now();

    private boolean active;

}

package com.company.flatmate.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.OffsetDateTime;
import java.util.UUID;

@Data
@NoArgsConstructor
public class RenterDto {

    private UUID id;

    private String login;

    private double maxPrice;

    private UUID apartmentId;

    private OffsetDateTime publicationDate = OffsetDateTime.now();

    private UUID userId;

    private boolean active;
}

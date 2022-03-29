package com.company.flatmate.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
public class ApartmentPhotoDto {
    private UUID id;

    private UUID apartmentId;

    private byte[] photo;
}

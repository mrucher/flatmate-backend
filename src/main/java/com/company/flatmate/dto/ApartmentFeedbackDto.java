package com.company.flatmate.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
public class ApartmentFeedbackDto {
    private UUID id;

    private Integer value;

    private String feedback;

    private UUID apartmentId;

//    @JsonProperty("authorId")
@JsonIgnore
private UUID authorId;
}

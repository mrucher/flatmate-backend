package com.company.flatmate.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
public class RenterFeedbackDto {
    @JsonIgnore
    private UUID id;

    private int value;

    private String feedback;

    private UUID renterId;

//    @JsonProperty("author")
//    private User author;
}

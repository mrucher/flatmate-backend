package com.company.flatmate.util.mapper;

import com.company.flatmate.dto.ApartmentFeedbackDto;
import com.company.flatmate.entity.ApartmentFeedback;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ApartmentFeedbackMapper {
    ApartmentFeedbackDto feedbackToDto(ApartmentFeedback feedback);

    ApartmentFeedback dtoToFeedback(ApartmentFeedbackDto feedbackDto);

    List<ApartmentFeedbackDto> apartmentFeedbackListToDtoList(List<ApartmentFeedback> apartmentFeedbackList);
}

package com.company.flatmate.service;

import com.company.flatmate.dto.ApartmentFeedbackDto;
import com.company.flatmate.repository.ApartmentFeedbackRepository;
import com.company.flatmate.util.mapper.ApartmentFeedbackMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.annotation.Nonnull;
import javax.transaction.Transactional;
import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
@Transactional
public class ApartmentFeedbackService {

    private final ApartmentFeedbackRepository repository;
    private final ApartmentFeedbackMapper mapper;


    public List<ApartmentFeedbackDto> findAllByApartmentId(@Nonnull UUID id) {
        return mapper.apartmentFeedbackListToDtoList(repository.findAllByApartmentId(id));
    }

    public List<ApartmentFeedbackDto> findAllByAuthorId(@Nonnull UUID id) {
        return mapper.apartmentFeedbackListToDtoList(repository.findAllByAuthorId(id));
    }

    public void save(ApartmentFeedbackDto feedback) {
        repository.save(mapper.dtoToFeedback(feedback));
    }


}

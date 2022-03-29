package com.company.flatmate.service;

import com.company.flatmate.dto.RenterFeedbackDto;
import com.company.flatmate.repository.RenterFeedbackRepository;
import com.company.flatmate.util.mapper.RenterFeedbackMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.annotation.Nonnull;
import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class RenterFeedbackService {

    private RenterFeedbackRepository repository;
    private RenterFeedbackMapper mapper;

    public void save(RenterFeedbackDto renterFeedback) {
        repository.save(mapper.dtoToRenterFeedback(renterFeedback));
    }

    public List<RenterFeedbackDto> findAllByRenterId(@Nonnull UUID id){
        return mapper.renterFeedbackListToDtoList(repository.findAllByRenterId(id));
    }
}

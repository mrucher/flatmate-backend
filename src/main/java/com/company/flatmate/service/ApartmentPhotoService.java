package com.company.flatmate.service;

import com.company.flatmate.dto.ApartmentPhotoDto;
import com.company.flatmate.repository.ApartmentPhotoRepository;
import com.company.flatmate.util.mapper.ApartmentPhotoMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.annotation.Nonnull;
import javax.transaction.Transactional;
import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
@Transactional
public class ApartmentPhotoService {

    private final ApartmentPhotoRepository repository;
    private final ApartmentPhotoMapper mapper;

    public List<ApartmentPhotoDto> findAllByApartmentId(@Nonnull UUID id) {
        return mapper.apartmentPhotoListToDtoList(repository.findAllByApartmentId(id));
    }

    public void save(ApartmentPhotoDto photo) {
        repository.save(mapper.dtoToPhoto(photo));
    }
}

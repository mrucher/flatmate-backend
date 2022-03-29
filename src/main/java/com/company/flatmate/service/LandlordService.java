package com.company.flatmate.service;

import com.company.flatmate.dto.LandlordDto;
import com.company.flatmate.entity.Landlord;
import com.company.flatmate.exception.NoSuchDataException;
import com.company.flatmate.repository.LandlordRepository;
import com.company.flatmate.util.mapper.LandlordMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.annotation.Nonnull;
import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
public class LandlordService {

    private final LandlordRepository repository;
    private final UserService userService;
    private final LandlordMapper mapper;


    public void save(LandlordDto landlord) {
        repository.save(mapper.dtoToLandlord(landlord));
    }

    public LandlordDto findById(@Nonnull UUID id) {
        Optional<Landlord> landlord = repository.findById(id);
        if (landlord.isEmpty()) {
            throw new NoSuchDataException();
        }
        LandlordDto dto = mapper.landlordToDto(landlord.get());
        setLogin(dto);
        return dto;
    }

    private void setLogin(LandlordDto dto) {
        dto.setLogin(userService.findById(dto.getUserId()).getLogin());
    }
}

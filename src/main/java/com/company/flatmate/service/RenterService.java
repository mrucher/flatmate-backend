package com.company.flatmate.service;

import com.company.flatmate.dto.RenterDto;
import com.company.flatmate.entity.Renter;
import com.company.flatmate.exception.NoSuchDataException;
import com.company.flatmate.repository.RenterRepository;
import com.company.flatmate.util.mapper.RenterMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.annotation.Nonnull;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
public class RenterService {

    private final RenterRepository repository;
    private final UserService userService;
    private final RenterMapper mapper;


    public List<RenterDto> getRenters() {
        return mapper.renterListToDtoList(repository.findAll());
    }

    public List<RenterDto> findAllByActive(boolean active) {
        List<RenterDto> list = mapper.renterListToDtoList(repository.findAllByActive(active));
        for (RenterDto dto : list) {
            setLogin(dto);
        }
        return list;
    }

    public RenterDto findById(@Nonnull UUID id) {
        Optional<Renter> renter = repository.findById(id);
        if (renter.isEmpty()) {
            throw new NoSuchDataException();
        }
        RenterDto dto = mapper.renterToDto(renter.get());
        setLogin(dto);
        return dto;
    }

    public List<RenterDto> findAllByMaxPriceBetween(double min, double max) {
        List<RenterDto> list = mapper.renterListToDtoList(repository.findAllByMaxPriceBetweenAndActive(min, max, true));
        for (RenterDto dto : list) {
            setLogin(dto);
        }
        return list;
    }

    public void save(RenterDto renter) {
        repository.save(mapper.dtoToRenter(renter));
    }

    public void deleteById(@Nonnull UUID id) {
        repository.deleteById(id);
    }

    void setLogin(RenterDto dto) {
        dto.setLogin(userService.findById(dto.getUserId()).getLogin());
    }
}

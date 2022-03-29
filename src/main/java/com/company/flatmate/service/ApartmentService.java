package com.company.flatmate.service;

import com.company.flatmate.dto.ApartmentDto;
import com.company.flatmate.dto.RenterDto;
import com.company.flatmate.entity.Apartment;
import com.company.flatmate.exception.NoSuchDataException;
import com.company.flatmate.repository.ApartmentRepository;
import com.company.flatmate.util.mapper.ApartmentMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.annotation.Nonnull;
import javax.transaction.Transactional;
import java.time.OffsetDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
@Transactional
public class ApartmentService {

    private final ApartmentRepository repository;
    private final RenterService service;
    private final ApartmentMapper mapper;


    public ApartmentDto findById(@Nonnull UUID id) {
        Optional<Apartment> apart = repository.findById(id);
        if (apart.isEmpty()) {
            throw new NoSuchDataException();
        }
        ApartmentDto dto = mapper.apartmentToDto(apart.get());
        for (RenterDto renter : dto.getRenters()) {
            service.setLogin(renter);
        }
        return dto;
    }

    public List<ApartmentDto> findAll() {
        List<ApartmentDto> list = mapper.apartmentListToDtoList(repository.findAll());
        for (ApartmentDto dto : list) {
            for (RenterDto renter : dto.getRenters()) {
                service.setLogin(renter);
            }
        }
        return list;
    }

    public List<ApartmentDto> findAllByActive(boolean active) {
        List<ApartmentDto> list = mapper.apartmentListToDtoList(repository.findAllByActive(active));
        for (ApartmentDto dto : list) {
            for (RenterDto renter : dto.getRenters()) {
                service.setLogin(renter);
            }
        }
        return list;
    }

    public List<ApartmentDto> findAllByPriceBetween(double min, double max) {
        List<ApartmentDto> list = mapper.apartmentListToDtoList(repository.findAllByPriceBetweenAndActive(min, max, true));
        for (ApartmentDto dto : list) {
            for (RenterDto renter : dto.getRenters()) {
                service.setLogin(renter);
            }
        }
        return list;
    }

    public List<ApartmentDto> findAllByLodgerCount(int count) {
        List<ApartmentDto> list = mapper.apartmentListToDtoList(repository.findAllByLodgerCountAndActive(count, true));
        for (ApartmentDto dto : list) {
            for (RenterDto renter : dto.getRenters()) {
                service.setLogin(renter);
            }
        }
        return list;
    }

    public List<ApartmentDto> findAllByRoomsCount(int count) {
        List<ApartmentDto> list = mapper.apartmentListToDtoList(repository.findAllByRoomsCountAndActive(count, true));
        for (ApartmentDto dto : list) {
            for (RenterDto renter : dto.getRenters()) {
                service.setLogin(renter);
            }
        }
        return list;
    }

    public UUID save(ApartmentDto apartment) {
        return repository.save(mapper.dtoToApartment(apartment)).getId();
    }

    public void deleteAllByActive(boolean active) {
        repository.deleteAllByActive(active);
    }

    public void deleteAllByDateBefore(@Nonnull OffsetDateTime date) {
        repository.deleteAllByPublicationDateBefore(date);
    }

    public void deleteById(@Nonnull UUID id) {
        repository.deleteById(id);
    }
}

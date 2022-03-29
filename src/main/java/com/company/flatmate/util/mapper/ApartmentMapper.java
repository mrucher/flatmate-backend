package com.company.flatmate.util.mapper;

import com.company.flatmate.dto.ApartmentDto;
import com.company.flatmate.entity.Apartment;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ApartmentMapper {
    ApartmentDto apartmentToDto(Apartment apartment);

    Apartment dtoToApartment(ApartmentDto apartmentDto);

    List<ApartmentDto> apartmentListToDtoList(List<Apartment> apartmentList);
}

package com.company.flatmate.util.mapper;

import com.company.flatmate.dto.RenterDto;
import com.company.flatmate.entity.Renter;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface RenterMapper {
    RenterDto renterToDto(Renter renter);

    Renter dtoToRenter(RenterDto renterDto);

    List<RenterDto> renterListToDtoList(List<Renter> renterList);
}

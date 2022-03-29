package com.company.flatmate.util.mapper;

import com.company.flatmate.dto.LandlordDto;
import com.company.flatmate.entity.Landlord;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface LandlordMapper {
    LandlordDto landlordToDto(Landlord landlord);

    Landlord dtoToLandlord(LandlordDto landlordDto);

    List<LandlordDto> landlordListToDtoList(List<Landlord> landlordList);
}

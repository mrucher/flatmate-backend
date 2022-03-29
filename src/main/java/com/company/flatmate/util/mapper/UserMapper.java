package com.company.flatmate.util.mapper;

import com.company.flatmate.dto.UserDto;
import com.company.flatmate.entity.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserDto userToDto(User user);

    User dtoToUser(UserDto userDto);
}

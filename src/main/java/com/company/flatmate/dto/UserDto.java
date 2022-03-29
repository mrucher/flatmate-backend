package com.company.flatmate.dto;

import com.company.flatmate.entity.Landlord;
import com.company.flatmate.entity.Renter;
import com.company.flatmate.entity.Role;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Data
@NoArgsConstructor
public class UserDto {
    private UUID id;

    private String login;

    private String password;

    private String firstname;

    private String city;

    private String email;

    private List<Renter> renters;

    private List<Landlord> landlords;

    private byte[]photo;

    private Role role;
}

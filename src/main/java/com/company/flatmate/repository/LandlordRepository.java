package com.company.flatmate.repository;

import com.company.flatmate.entity.Apartment;
import com.company.flatmate.entity.Landlord;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.annotation.Nonnull;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface LandlordRepository extends CrudRepository<Landlord, UUID> {
    List<Landlord> findAll();

    Optional<Landlord> findById(@Nonnull UUID id);

}
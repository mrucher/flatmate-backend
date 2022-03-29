package com.company.flatmate.repository;

import com.company.flatmate.entity.Renter;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.annotation.Nonnull;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface RenterRepository extends CrudRepository<Renter, UUID> {
    List<Renter> findAll();

    List<Renter> findAllByActive(boolean active);

    Optional<Renter> findById(@Nonnull UUID id);

    List<Renter> findAllByMaxPriceBetweenAndActive(double min, double max, boolean active);

    void deleteById(@Nonnull UUID id);
}
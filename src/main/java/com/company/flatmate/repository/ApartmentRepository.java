package com.company.flatmate.repository;

import com.company.flatmate.entity.Apartment;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.annotation.Nonnull;
import java.time.OffsetDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface ApartmentRepository extends CrudRepository<Apartment, UUID> {

    Optional<Apartment> findById(@Nonnull UUID id);

    List<Apartment> findAll();

    List<Apartment> findAllByActive(boolean active);

    List<Apartment> findAllByPriceBetweenAndActive(double min, double max, boolean active);

    List<Apartment> findAllByLodgerCountAndActive(int count, boolean active);

    List<Apartment> findAllByRoomsCountAndActive(int count, boolean active);

    void deleteById(@Nonnull UUID id);

    void deleteAllByActive(boolean active);

    void deleteAllByPublicationDateBefore(@Nonnull OffsetDateTime date);

}

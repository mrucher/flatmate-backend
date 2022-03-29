package com.company.flatmate.repository;

import com.company.flatmate.entity.ApartmentPhoto;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.annotation.Nonnull;
import java.util.List;
import java.util.UUID;

@Repository
public interface ApartmentPhotoRepository extends CrudRepository<ApartmentPhoto, UUID> {

    List<ApartmentPhoto> findAllByApartmentId(@Nonnull UUID id);

}

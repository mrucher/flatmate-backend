package com.company.flatmate.repository;

import com.company.flatmate.entity.ApartmentFeedback;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.annotation.Nonnull;
import java.util.List;
import java.util.UUID;

@Repository
public interface ApartmentFeedbackRepository extends CrudRepository<ApartmentFeedback, UUID> {

    List<ApartmentFeedback> findAllByApartmentId(@Nonnull UUID id);

    List<ApartmentFeedback> findAllByAuthorId(@Nonnull UUID id);

    // fixme: добавить каскадное удаление в V1__create_tables.sql по автору)
    void deleteAllByAuthorId(@Nonnull UUID id);
}

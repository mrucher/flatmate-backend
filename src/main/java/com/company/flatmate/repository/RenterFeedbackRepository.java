package com.company.flatmate.repository;


import com.company.flatmate.entity.Renter;
import com.company.flatmate.entity.RenterFeedback;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.annotation.Nonnull;
import java.util.List;
import java.util.UUID;

@Repository
public interface RenterFeedbackRepository extends CrudRepository<RenterFeedback, UUID> {
    List<RenterFeedback> findAll();

    List<RenterFeedback> findAllByRenterId(@Nonnull UUID id);
}
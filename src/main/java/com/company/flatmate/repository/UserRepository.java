package com.company.flatmate.repository;

import com.company.flatmate.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.annotation.Nonnull;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserRepository extends CrudRepository<User, UUID> {

    List<User> findAll();

    User findByLogin(String login);

    Optional<User> findById(@Nonnull UUID id);
}
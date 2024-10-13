package com.EventIq.EventIq.Repositories;

import com.EventIq.EventIq.Entities.UserTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserRepo extends JpaRepository<UserTable, UUID> {
    Optional<UserTable> findByEmail(String email);
}

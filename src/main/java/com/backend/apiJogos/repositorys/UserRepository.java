package com.backend.apijogos.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.backend.apijogos.models.User;

@Repository
public interface UserRepository extends JpaRepository<User, UUID> {
}
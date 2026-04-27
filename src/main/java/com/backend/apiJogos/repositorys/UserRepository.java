package com.backend.apijogos.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.backend.apijogos.models.User;

public interface UserRepository extends JpaRepository<User, UUID> {
    
}
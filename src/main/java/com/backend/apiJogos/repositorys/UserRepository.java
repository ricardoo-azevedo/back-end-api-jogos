package com.backend.apiJogos.repositorys;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.backend.apiJogos.models.User;

@Repository
public interface UserRepository extends JpaRepository<User, UUID> {

  boolean existsByNome(String nome);

}

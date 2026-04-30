package com.backend.apiJogos.repositories;

import java.util.UUID;
import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;

import com.backend.apiJogos.models.Game;

public interface GameRepository extends JpaRepository<Game, UUID> {
  List<Game> findByNomeContainingIgnoreCase(String nome);
}

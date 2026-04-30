package com.backend.apiJogos.services.interfaces;

import java.util.List;
import java.util.UUID;

import com.backend.apiJogos.dtos.GameDto;

public interface GameService {
    GameDto criar (GameDto gameDto);

    List<GameDto> listar();

    GameDto buscarPorId(UUID id);

    void deletar(UUID id);

    GameDto editar(UUID id, GameDto gameDto);

    List<GameDto> buscarPorNome(String nome);

}

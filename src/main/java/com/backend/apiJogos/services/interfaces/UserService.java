package com.backend.apiJogos.services.interfaces;

import java.util.List;
import java.util.UUID;

import com.backend.apiJogos.dtos.UserDto;

public interface UserService {
    UserDto criarUsuario(UserDto userDto);
    UserDto editarPorId(UserDto userDto, UUID id);
    List<UserDto> listarUsuarios();
    UserDto buscarPorId (UUID id);
    List<UserDto>buscarPorNome(String nome);
    void deletarUsuario (UUID id);
}

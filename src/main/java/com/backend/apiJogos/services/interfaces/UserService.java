package com.backend.apiJogos.services.interfaces;

import java.util.List;
import java.util.UUID;

import com.backend.apiJogos.dtos.UserDto;

public interface UserService {
    UserDto criarUsuario(UserDto userDto);
    List<UserDto> listarUsuarios();
    UserDto buscarPorId (UUID id);
    void deletarUsuario (UUID id);
}

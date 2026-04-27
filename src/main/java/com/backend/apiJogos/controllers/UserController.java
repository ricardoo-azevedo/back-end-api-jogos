package com.backend.apijogos.controllers;

import java.util.List;
import java.util.UUID;

import org.springframework.web.bind.annotation.*;

import com.backend.apijogos.dtos.UserDto;
import com.backend.apijogos.services.interfaces.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }
    @PostMapping
    public UserDto criar(@RequestBody UserDto userDto){
        return userService.criarUsuario(userDto);
    }
    @GetMapping
    public List<UserDto> listar(){
        return userService.listarUsuarios();
    }
    @GetMapping("/{id}")
    public UserDto buscarPorId(@PathVariable UUID id){
       return userService.buscarPorId(id);
    }
    @DeleteMapping("/{id}")
    public void deletar(@PathVariable UUID id){
        userService.deletarUsuario(id);
    }
}
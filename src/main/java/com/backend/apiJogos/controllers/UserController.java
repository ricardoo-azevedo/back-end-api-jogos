package com.backend.apiJogos.controllers;

import java.util.List;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import com.backend.apiJogos.dtos.UserDto;
import com.backend.apiJogos.services.interfaces.UserService;

import jakarta.validation.Valid;

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
    @GetMapping("/buscar-id/{id}")
    public UserDto buscarPorId(@PathVariable UUID id){
       return userService.buscarPorId(id);
    }
    @DeleteMapping("/{id}")
    public void deletar(@PathVariable UUID id){
        userService.deletarUsuario(id);
    }

  @PutMapping("/{id}")
  public ResponseEntity<?> editar(@RequestBody @Valid UserDto uDto, BindingResult br, @PathVariable UUID id){
    if(br.hasErrors()){
      return ResponseEntity.badRequest().body(br.getAllErrors());
    }

    UserDto userEditado = userService.editarPorId(uDto, id);

    return ResponseEntity.status(HttpStatus.OK).body(userEditado);
  }

  @GetMapping("/buscar-nome/{nome}")
  public ResponseEntity<List<?>> buscarPorNome(@PathVariable String nome){
    List<UserDto> listaAproximada = userService.buscarPorNome(nome);
    return ResponseEntity.ok().body(listaAproximada);

  }








}

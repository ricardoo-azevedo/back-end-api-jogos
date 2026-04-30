package com.backend.apiJogos.controllers;

import java.util.List;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import com.backend.apiJogos.dtos.GameDto;
import com.backend.apiJogos.services.interfaces.GameService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/games")
public class GameController {
    private final GameService gameService;

    public GameController(GameService gameService){
        this.gameService = gameService;
    }
    @PostMapping
    public GameDto criar(@RequestBody @Valid GameDto gameDto){
        return gameService.criar(gameDto);
    }
    @GetMapping
    public List<GameDto> listar(){
        return gameService.listar();
    }
    @GetMapping("/buscar-id/{id}")
    public GameDto buscarPorId(@PathVariable UUID id){
       return gameService.buscarPorId(id);
    }
    @DeleteMapping("/{id}")
    public void deletar(@PathVariable UUID id){
        gameService.deletar(id);
    }

  @PutMapping("/{id}")
  public ResponseEntity<?> editar(@RequestBody @Valid GameDto gameDto, BindingResult br, @PathVariable UUID id){
    if(br.hasErrors()){
      return ResponseEntity.badRequest().body(br.getAllErrors());
    }

    GameDto gameEditado = gameService.editar(id, gameDto);

    return ResponseEntity.status(HttpStatus.OK).body(gameEditado);
  }

  @GetMapping("/buscar-nome/{nome}")
  public ResponseEntity<List<GameDto>> buscarPorNome(@PathVariable String nome){
    List<GameDto> lista = gameService.buscarPorNome(nome);
    return ResponseEntity.ok(lista);

  }








}

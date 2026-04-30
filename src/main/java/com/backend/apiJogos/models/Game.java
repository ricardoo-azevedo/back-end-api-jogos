package com.backend.apiJogos.models;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
@Table(name = "tb_game")
@NoArgsConstructor
@AllArgsConstructor

public class Game {
    @Id
@GeneratedValue(strategy = GenerationType.UUID)
private UUID id;

@Column(nullable = false)
private String nome;

public Game(String nome){
    this.nome = nome;
}
}

package com.backend.apijogos.models;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
@Table(name = "tb_usuario")
@NoArgsConstructor
@AllArgsConstructor

public class User {
    @Id
    private UUID id;
    @Column(nullable = false)
    private String nome;
    
    public User(String nome){
        this.id = UUID.randomUUID();
        this.nome = nome;
    }
}
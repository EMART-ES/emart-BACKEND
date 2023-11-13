package com.example.emart.models;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tb_usuario")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "nome não pode ser nulo")
    private String nome;

    @Schema(example = "example@email.com")
    @Email
    private String email;

    @NotBlank(message = "senhaUsuario não pode ser nullo")
    private String senha;

    @NotBlank(message = "apelidoUsuario não pode ser nullo")
    private String usuario;

    private int idade;

    private String foto;
}
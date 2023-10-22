package com.example.emart.models;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
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

    @Schema(example = "example@email.com")
    @Email
    @NotBlank(message = "emailUsuario não pode ser nullo")
    @Size(max = 255, message = "emailUsuario não pode ultrapassar 255 caracteres")
    private String email;

    @NotBlank(message = "senhaUsuario não pode ser nullo")
    @Size(max = 255, message = "senhaUsuario não pode ultrapassar 255 caracteres")
    private String senha;

    @NotBlank(message = "apelidoUsuario não pode ser nullo")
    @Size(max = 255, message = "apelidoUsuario não pode ultrapassar 255 caracteres")
    private String usuario;

    @NotBlank(message = "nomeCompletoUsuario não pode ser nullo")
    @Size(max = 255, message = "nomeCompletoUsuario não pode ultrapassar 255 caracteres")
    private String nome;

    private int idade;

    private String foto;

    private Integer tipo;

}
package com.example.emart.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "tb_categoria")
@Data
public class Categoria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "nomeCategoria não pode ser nulo")
    @Size(max = 255, message = "descricaoCategoria não pode ultrapassar 255 caracteres")
    private String nome;
    @NotBlank(message = "descricaoCategoria não pode ser nulo")
    @Size(max = 255, message = "descricaoCategoria não pode ultrapassar 255 caracteres")
    private String descricao;
    private String complemento;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "categoriaDoProduto", cascade = CascadeType.REMOVE)
    @JsonIgnoreProperties("categoriaDoProduto")
    private List<Produto> produtosDaCategoria;
}

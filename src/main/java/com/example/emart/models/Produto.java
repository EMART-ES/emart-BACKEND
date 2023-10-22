package com.example.emart.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.math.BigDecimal;

@Entity
@Table(name = "tb_produto")
@Data
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "nomeProduto não pode ser nullo")
    @Size(max = 255, message = "nomeproduto não pode ultrapassar 255 caracteres")
    private String nome;
    @NotNull(message = "quantidadeProduto não pode ser nullo")
    private int quantidade;
    @NotNull(message = "precoProduto não pode ser nullo")
    private BigDecimal preco;

    @NotNull
    @ManyToOne
    @JsonIgnoreProperties("produtosDaCategoria")
    private Categoria categoriaDoProduto;
}

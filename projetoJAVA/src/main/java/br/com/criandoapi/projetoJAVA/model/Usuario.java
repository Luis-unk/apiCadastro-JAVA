package br.com.criandoapi.projetoJAVA.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;

@Data

@Entity
@Table(name = "usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @NotBlank(message = "O nome é obrigatório!")
    @Size(min = 3, message = "O nome deve conter no minímo 3 caracteres!")
    @Column(name = "nome", length = 200, nullable = false)
    private String nome;

    @Email(message = "Insira um email valido!")
    @NotBlank(message = "O email é obrigatório!")
    @Column(name = "email", length = 100, nullable = false)
    private String email;

    @NotBlank(message = "A senha é obrigatória!")
    @Column(name = "senha", columnDefinition = "TEXT", nullable = false)
    private String senha;

    @NotBlank(message = "O Telefone é obrigatório!")
    @Column(name = "telefone", length = 15, nullable = false)
    private String telefone;

}

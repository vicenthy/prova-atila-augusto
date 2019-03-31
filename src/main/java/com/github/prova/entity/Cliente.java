package com.github.prova.entity;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.io.Serializable;
import java.time.LocalDate;


@Entity
@Table(name = "cliente")
@Data
public class Cliente implements Serializable {

    private static final long serialVersionUID = 6435109961353514049L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "o cpf não foi preenchido")
    @Size(min = 11, max = 11, message = "Tamanho do cpf incorreto")
    @Column(name = "cpf", nullable = false, length = 11)
    private String cpf;
    @Column(name = "nome", nullable = false)
    @NotBlank(message = "o nome não foi preenchido")
    private String nome;
    @Column(name = "email", nullable = false)
    @NotBlank(message = "o email não foi preenchido")
    @Email(message = "Digite um email valido")
    private String email;
    @Column(name = "data_nascimento", nullable = false)
    @NotNull(message = "a data de nascimento não foi preenchida")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dataNascimento;
    @Column(name = "sexo", nullable = false, length = 1)
    @NotBlank(message = "o sexo não foi preenchido")
    private String Sexo;
    @Column(name = "estado_civil", nullable = false)
    @NotBlank(message = "o estado civil não foi preenchido")
    private String estadoCivel;
    @Column(name = "status", nullable = false, length = 1)
    @NotNull(message = "Status NULL ")
    private boolean status;



}

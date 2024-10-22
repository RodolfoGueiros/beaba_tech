package com.generation.beaba_tech.entity;

import jakarta.persistence.*;
import lombok.Data;
//import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Data
@Entity
@Table(name = "TB_TURMA")
public class Turma {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Nome é obrigatório")
    @Size(min = 3, message = "Nome deve ter no mínimo 3 caracteres")
    private String nome;

    @NotBlank(message = "Instrutor é obrigatório")
    private String instrutor;

    @OneToOne
    @JoinColumn(name = "aluno_id")
    private Aluno aluno;
}


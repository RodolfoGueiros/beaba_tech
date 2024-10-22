package com.generation.beaba_tech.entity;

import jakarta.persistence.*;
import lombok.Data;
//import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Data
@Entity
@Table(name = "TB_ALUNO")
public class Aluno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Nome é obrigatório")
    @Size(min = 3, message = "Nome deve ter no mínimo 3 caracteres")
    private String nome;

    @NotBlank(message = "Email é obrigatório")
    @Email(message = "Email deve ser válido")
    @Column(unique = true)
    private String email;

    @Column(name = "nota_um")
    private Double notaUm;

    @Column(name = "nota_dois")
    private Double notaDois;

    @Column(name = "media")
    private Double media;

    @PrePersist
    @PreUpdate
    private void calculateMedia() {
        if (notaUm != null && notaDois != null) {
            this.media = (notaUm + notaDois) / 2;
        }
    }
}

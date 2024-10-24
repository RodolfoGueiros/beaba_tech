package com.generation.beaba_tech.dto;


import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class FuncionarioResponse {
    private Long id;
    private String nome;
    private String email;
    private String cargo;
}

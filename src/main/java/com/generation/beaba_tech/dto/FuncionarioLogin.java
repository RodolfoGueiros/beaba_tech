package com.generation.beaba_tech.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FuncionarioLogin {
    private Long id;
    private String nome;
    private String email;
    private String senha;
    private String cargo;
    private String token;
}

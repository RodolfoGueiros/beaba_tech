package com.generation.beaba_tech.dto;

import lombok.Data;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

@Data
public class LoginRequestDTO {
    @NotBlank
    @Email
    private String email;

    @NotBlank
    private String senha;
}

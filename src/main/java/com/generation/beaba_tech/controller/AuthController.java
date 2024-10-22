package com.generation.beaba_tech.controller;

import com.generation.beaba_tech.dto.LoginRequestDTO;
import com.generation.beaba_tech.dto.JwtAuthResponseDTO;
import com.generation.beaba_tech.entity.Funcionario;
import com.generation.beaba_tech.security.JwtTokenProvider;
import com.generation.beaba_tech.service.FuncionarioService;
import io.swagger.annotations.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
@Api(tags = "Autenticação")
public class AuthController {

    private final AuthenticationManager authenticationManager;
    private final JwtTokenProvider tokenProvider;
    private final FuncionarioService funcionarioService;

    @PostMapping("/login")
    @ApiOperation("Login de funcionário")
    public ResponseEntity<JwtAuthResponseDTO> login(@Valid @RequestBody LoginRequestDTO loginRequest) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequest.getEmail(),
                        loginRequest.getSenha()
                )
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = tokenProvider.generateToken(authentication);

        return ResponseEntity.ok(new JwtAuthResponseDTO(jwt));
    }

    @PostMapping("/register")
    @ApiOperation("Registrar novo funcionário")
    public ResponseEntity<Funcionario> register(@Valid @RequestBody Funcionario funcionario) {
        return ResponseEntity.ok(funcionarioService.save(funcionario));
    }
}

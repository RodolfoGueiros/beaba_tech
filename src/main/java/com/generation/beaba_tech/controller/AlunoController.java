package com.generation.beaba_tech.controller;

import com.generation.beaba_tech.entity.Aluno;
import com.generation.beaba_tech.service.AlunoService;
//import io.swagger.annotations.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/alunos")
@Tag(name = "Aluno")
public class AlunoController {

    @Autowired
    private AlunoService alunoService;

    @PostMapping
    @Operation(summary = "Criar novo aluno")
    public ResponseEntity<Aluno> create(@Valid @RequestBody Aluno aluno) {
        return ResponseEntity.ok(alunoService.save(aluno));
    }

    @GetMapping
    @Operation(summary = "Listar todos os alunos")
    public ResponseEntity<List<Aluno>> findAll() {
        return ResponseEntity.ok(alunoService.findAll());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar aluno por ID")
    public ResponseEntity<Aluno> findById(@PathVariable Long id) {
        return ResponseEntity.ok(alunoService.findById(id));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualizar aluno")
    public ResponseEntity<Aluno> update(@PathVariable Long id, @Valid @RequestBody Aluno aluno) {
        return ResponseEntity.ok(alunoService.update(id, aluno));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Deletar aluno")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        alunoService.delete(id);
        return ResponseEntity.ok().build();
    }
}


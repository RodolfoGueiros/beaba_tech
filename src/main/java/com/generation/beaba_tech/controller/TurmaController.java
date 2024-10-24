package com.generation.beaba_tech.controller;

import com.generation.beaba_tech.entity.Turma;
import com.generation.beaba_tech.service.TurmaService;
//import io.swagger.annotations.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/turmas")
@Tag(name = "Turma")
public class TurmaController {

    @Autowired
    private TurmaService turmaService;

    @PostMapping
    @Operation(summary = "Criar nova turma")
    public ResponseEntity<Turma> create(@Valid @RequestBody Turma turma) {
        return ResponseEntity.ok(turmaService.save(turma));
    }

    @GetMapping
    @Operation(summary = "Listar todas as turmas")
    public ResponseEntity<List<Turma>> findAll() {
        return ResponseEntity.ok(turmaService.findAll());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar turma por ID")
    public ResponseEntity<Turma> findById(@PathVariable Long id) {
        return ResponseEntity.ok(turmaService.findById(id));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualizar turma")
    public ResponseEntity<Turma> update(@PathVariable Long id, @Valid @RequestBody Turma turma) {
        return ResponseEntity.ok(turmaService.update(id, turma));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Deletar turma")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        turmaService.delete(id);
        return ResponseEntity.ok().build();
    }
}

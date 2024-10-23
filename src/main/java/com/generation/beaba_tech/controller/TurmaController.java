package com.generation.beaba_tech.controller;

import com.generation.beaba_tech.entity.Turma;
import com.generation.beaba_tech.service.TurmaService;
//import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/turmas")
//@Api(tags = "Turma")
public class TurmaController {

    @Autowired
    private TurmaService turmaService;

    @PostMapping
//    @ApiOperation("Criar nova turma")
    public ResponseEntity<Turma> create(@Valid @RequestBody Turma turma) {
        return ResponseEntity.ok(turmaService.save(turma));
    }

    @GetMapping
//    @ApiOperation("Listar todas as turmas")
    public ResponseEntity<List<Turma>> findAll() {
        return ResponseEntity.ok(turmaService.findAll());
    }

    @GetMapping("/{id}")
//    @ApiOperation("Buscar turma por ID")
    public ResponseEntity<Turma> findById(@PathVariable Long id) {
        return ResponseEntity.ok(turmaService.findById(id));
    }

    @PutMapping("/{id}")
//    @ApiOperation("Atualizar turma")
    public ResponseEntity<Turma> update(@PathVariable Long id, @Valid @RequestBody Turma turma) {
        return ResponseEntity.ok(turmaService.update(id, turma));
    }

    @DeleteMapping("/{id}")
//    @ApiOperation("Deletar turma")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        turmaService.delete(id);
        return ResponseEntity.ok().build();
    }
}

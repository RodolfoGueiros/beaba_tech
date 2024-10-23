package com.generation.beaba_tech.controller;

import com.generation.beaba_tech.dto.FuncionarioLogin;
import com.generation.beaba_tech.entity.Funcionario;
import com.generation.beaba_tech.service.FuncionarioService;
//import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/funcionarios")
//@Api(tags = "Funcionário")
public class FuncionarioController {

    @Autowired
    private FuncionarioService funcionarioService;

    @PostMapping(path = "/registrar")
//    @ApiOperation("Criar novo funcionário")
    public ResponseEntity<Funcionario> create(@Valid @RequestBody Funcionario funcionario) {
        return ResponseEntity.ok(funcionarioService.save(funcionario));
    }

    @PostMapping("/logar")
    public ResponseEntity<FuncionarioLogin> authenticateUser(@RequestBody Optional<FuncionarioLogin> userLogin){

        return funcionarioService.authenticateUser(userLogin)
            .map(response ->ResponseEntity.status(HttpStatus.OK).body(response))
            .orElse(ResponseEntity.status(HttpStatus.UNAUTHORIZED).build());
    }

    @GetMapping
//    @ApiOperation("Listar todos os funcionários")
    public ResponseEntity<List<Funcionario>> findAll() {
        return ResponseEntity.ok(funcionarioService.findAll());
    }

    @GetMapping("/{id}")
//    @ApiOperation("Buscar funcionário por ID")
    public ResponseEntity<Funcionario> findById(@PathVariable Long id) {
        return ResponseEntity.ok(funcionarioService.findById(id));
    }

    @PutMapping("/{id}")
//    @ApiOperation("Atualizar funcionário")
    public ResponseEntity<Funcionario> update(@PathVariable Long id, @Valid @RequestBody Funcionario funcionario) {
        return ResponseEntity.ok(funcionarioService.update(id, funcionario));
    }

    @DeleteMapping("/{id}")
//    @ApiOperation("Deletar funcionário")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        funcionarioService.delete(id);
        return ResponseEntity.ok().build();
    }
}

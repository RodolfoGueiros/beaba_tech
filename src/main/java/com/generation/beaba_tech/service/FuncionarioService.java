package com.generation.beaba_tech.service;

import com.generation.beaba_tech.entity.Funcionario;
import com.generation.beaba_tech.repository.FuncionarioRepository;
import com.generation.beaba_tech.exception.ResourceNotFoundException;
import com.generation.beaba_tech.exception.BusinessException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FuncionarioService {
    private final FuncionarioRepository funcionarioRepository;
    private final PasswordEncoder passwordEncoder;

    public Funcionario findById(Long id) {
        return funcionarioRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Funcionário não encontrado"));
    }

    public List<Funcionario> findAll() {
        return funcionarioRepository.findAll();
    }

    public Funcionario save(Funcionario funcionario) {
        if (funcionarioRepository.existsByEmail(funcionario.getEmail())) {
            throw new BusinessException("Email já cadastrado");
        }
        funcionario.setSenha(passwordEncoder.encode(funcionario.getSenha()));
        return funcionarioRepository.save(funcionario);
    }

    public Funcionario update(Long id, Funcionario funcionario) {
        Funcionario existingFuncionario = findById(id);

        if (!existingFuncionario.getEmail().equals(funcionario.getEmail()) &&
                funcionarioRepository.existsByEmail(funcionario.getEmail())) {
            throw new BusinessException("Email já cadastrado");
        }

        if (funcionario.getSenha() != null && !funcionario.getSenha().isEmpty()) {
            funcionario.setSenha(passwordEncoder.encode(funcionario.getSenha()));
        } else {
            funcionario.setSenha(existingFuncionario.getSenha());
        }

        funcionario.setId(id);
        return funcionarioRepository.save(funcionario);
    }

    public void delete(Long id) {
        Funcionario funcionario = findById(id);
        funcionarioRepository.delete(funcionario);
    }
}

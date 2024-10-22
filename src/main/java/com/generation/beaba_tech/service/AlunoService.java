package com.generation.beaba_tech.service;

import com.generation.beaba_tech.entity.Aluno;
import com.generation.beaba_tech.repository.AlunoRepository;
import com.generation.beaba_tech.exception.ResourceNotFoundException;
import com.generation.beaba_tech.exception.BusinessException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AlunoService {
    private final AlunoRepository alunoRepository;

    public Aluno findById(Long id) {
        return alunoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Aluno não encontrado"));
    }

    public List<Aluno> findAll() {
        return alunoRepository.findAll();
    }

    public Aluno save(Aluno aluno) {
        if (alunoRepository.existsByEmail(aluno.getEmail())) {
            throw new BusinessException("Email já cadastrado");
        }
        return alunoRepository.save(aluno);
    }

    public Aluno update(Long id, Aluno aluno) {
        Aluno existingAluno = findById(id);

        if (!existingAluno.getEmail().equals(aluno.getEmail()) &&
                alunoRepository.existsByEmail(aluno.getEmail())) {
            throw new BusinessException("Email já cadastrado");
        }

        aluno.setId(id);
        return alunoRepository.save(aluno);
    }

    public void delete(Long id) {
        Aluno aluno = findById(id);
        alunoRepository.delete(aluno);
    }
}

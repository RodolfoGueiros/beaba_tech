package com.generation.beaba_tech.service;

import com.generation.beaba_tech.entity.Turma;
import com.generation.beaba_tech.repository.TurmaRepository;
import com.generation.beaba_tech.exception.ResourceNotFoundException;
import com.generation.beaba_tech.exception.BusinessException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TurmaService {
    private final TurmaRepository turmaRepository;

    public Turma findById(Long id) {
        return turmaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Turma não encontrada"));
    }

    public List<Turma> findAll() {
        return turmaRepository.findAll();
    }

    public Turma save(Turma turma) {
        if (turma.getAluno() != null && turmaRepository.existsByAlunoId(turma.getAluno().getId())) {
            throw new BusinessException("Aluno já está matriculado em uma turma");
        }
        return turmaRepository.save(turma);
    }

    public Turma update(Long id, Turma turma) {
        Turma existingTurma = findById(id);

        if (turma.getAluno() != null &&
                !turma.getAluno().getId().equals(existingTurma.getAluno().getId()) &&
                turmaRepository.existsByAlunoId(turma.getAluno().getId())) {
            throw new BusinessException("Aluno já está matriculado em uma turma");
        }

        turma.setId(id);
        return turmaRepository.save(turma);
    }

    public void delete(Long id) {
        Turma turma = findById(id);
        turmaRepository.delete(turma);
    }
}

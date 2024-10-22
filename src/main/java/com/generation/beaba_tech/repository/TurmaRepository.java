package com.generation.beaba_tech.repository;

import com.generation.beaba_tech.entity.Turma;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TurmaRepository extends JpaRepository<Turma, Long> {
    boolean existsByAlunoId(Long alunoId);
}

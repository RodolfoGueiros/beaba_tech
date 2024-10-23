package com.generation.beaba_tech.service;

import com.generation.beaba_tech.dto.FuncionarioLogin;
import com.generation.beaba_tech.entity.Funcionario;
import com.generation.beaba_tech.repository.FuncionarioRepository;
import com.generation.beaba_tech.exception.ResourceNotFoundException;
import com.generation.beaba_tech.exception.BusinessException;
import com.generation.beaba_tech.security.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class FuncionarioService {
    @Autowired
    private JwtService jwtService;
    
    @Autowired
    private AuthenticationManager authenticationManager;

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

    public Optional<FuncionarioLogin> authenticateUser(Optional<FuncionarioLogin> funcionarioLogin) {
        if (funcionarioLogin.isEmpty()) {
            return Optional.empty();
        }
        
        var credentials = new UsernamePasswordAuthenticationToken(funcionarioLogin.get().getEmail(), funcionarioLogin.get().getSenha());
        
        Authentication authentication = authenticationManager.authenticate(credentials);
        
        if (authentication.isAuthenticated()) {
            Optional<Funcionario> user = funcionarioRepository.findByEmail(funcionarioLogin.get().getEmail());
            
            if (user.isPresent()) {
                funcionarioLogin.get().setId(user.get().getId());
                funcionarioLogin.get().setNome(user.get().getNome());
                funcionarioLogin.get().setEmail(user.get().getEmail());
                funcionarioLogin.get().setSenha("");
                funcionarioLogin.get().setToken(generateToken(funcionarioLogin.get().getEmail()));
                
                return funcionarioLogin;
            }
        }
        return Optional.empty();
    }
    
    private String hashPassword(String password) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        return encoder.encode(password);
    }
    
    private String generateToken(String user) {
        return "Bearer " + jwtService.generateToken(user);
    }
}

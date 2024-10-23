package com.generation.beaba_tech.security;


import com.generation.beaba_tech.entity.Funcionario;
import com.generation.beaba_tech.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
  
  @Autowired
  private FuncionarioRepository funcionarioRepository;
  
  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    Optional<Funcionario> funcionario = funcionarioRepository.findByEmail(username);
    
    if (funcionario.isPresent()) {
      return new UserDetailsImpl(funcionario.get());
    } else {
      throw new ResponseStatusException(HttpStatus.FORBIDDEN);
    }
  }
}
package com.aula.ProjetoTeste.User;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface UserRepository extends JpaRepository<UserModel, UUID> {
    
    UserModel findByUsername(String username);
}
    

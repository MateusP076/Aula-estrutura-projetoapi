package com.aula.ProjetoTeste.User;


import at.favre.lib.crypto.bcrypt.BCrypt;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/user")
public class UserControler {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/")
    public String retorno(){
        return "Ola novo usuario seja bem vindo a nossa base de dados";
    }

    @PostMapping ("/criar")
    public ResponseEntity criar(@RequestBody UserModel userModel, HttpServletRequest request) {
        var criado = this.userRepository.findByUsername(userModel.getUsername());
        if (criado != null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Usuario ja existente");
        } else {
            var hahssenha= BCrypt.withDefaults().hashToString(12, userModel.getSenha().toCharArray());
            userModel.setSenha(hahssenha);
            var salvar = this.userRepository.save(userModel);
            return ResponseEntity.status(HttpStatus.CREATED).body(salvar);
        }

    }
    @GetMapping("/Listar")
    public List<UserModel> listar(){
        List<UserModel> usuariocad = userRepository.findAll();
        return usuariocad;
    }
    @PutMapping("/Atualizar")
    public ResponseEntity atualizar(@RequestBody UserModel userModel) {
        var hahssenha= BCrypt.withDefaults().hashToString(12, userModel.getSenha().toCharArray());
        userModel.setSenha(hahssenha);
        var criado= this.userRepository.save(userModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(criado);
    }
    @DeleteMapping("/Deletar/{iduser}")
    public void deletar(@PathVariable UUID iduser) {
        userRepository.deleteById(iduser);
    }
}

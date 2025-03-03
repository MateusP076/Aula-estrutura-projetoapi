package com.aula.ProjetoTeste.User;


import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

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
    public ResponseEntity criar(@RequestBody UserModel userModel, HttpServletRequest request){
            var criado=this.userRepository.findByUsername(userModel.getUsername());
            if (criado!=null){
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Usuario ja existente");
            } else {
                var salvar=this.userRepository.save(userModel);
            return ResponseEntity.status(HttpStatus.CREATED).body(salvar);
            }
    }
    
}

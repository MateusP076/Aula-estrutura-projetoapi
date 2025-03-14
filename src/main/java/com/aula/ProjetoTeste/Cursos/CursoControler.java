package com.aula.ProjetoTeste.Cursos;

import at.favre.lib.crypto.bcrypt.BCrypt;
import com.aula.ProjetoTeste.User.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.servlet.http.HttpServletRequest;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/curso")
public class CursoControler {
    @Autowired
    private CursoRepository cursoRepository;
    public String mensagem(){
        return"Bem vindo a nossa plataforma de cursos, por favor mude para(/cadastrar)";
    }
    @PostMapping("/cadastrar")
    public  ResponseEntity criar(@RequestBody Cursomodel cursomodel, HttpServletRequest request){
        var condicao= this.cursoRepository.findBynomecurso(cursomodel.getNomecurso());
        if (condicao!=null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Curso ja existe");
        } else{
            var hahstipo= BCrypt.withDefaults().hashToString(12, cursomodel.getTipo().toCharArray());
            cursomodel.setTipo(hahstipo);
            var salvar= this.cursoRepository.save(cursomodel);
            return ResponseEntity.status(HttpStatus.CREATED).body(salvar);
        }
    }
    @GetMapping("/Listar")
    public List<Cursomodel> listar(){
        List<Cursomodel> cursocad = cursoRepository.findAll();
        return cursocad;
    }
    @PutMapping("/Atualizar")
    public ResponseEntity atualizar(@RequestBody Cursomodel cursomodel) {
        var hahstipo= BCrypt.withDefaults().hashToString(12, cursomodel.getTipo().toCharArray());
        cursomodel.setTipo(hahstipo);
        var criado= this.cursoRepository.save(cursomodel);
        return ResponseEntity.status(HttpStatus.CREATED).body(criado);
    }
    @DeleteMapping("/Deletar/{iduser}")
    public void deletar(@PathVariable UUID idcurso) {
        cursoRepository.deleteById(idcurso);
    }
}

package com.aula.ProjetoTeste.Carros;

import at.favre.lib.crypto.bcrypt.BCrypt;
import com.aula.ProjetoTeste.Cursos.CursoRepository;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/Carro")
public class CarControler {
    @Autowired
    private CarRepository carRepository;
    
    @GetMapping("/Aviso")
    public String mensagem(){
        return"Aqui esta nossa base de dados dos carros por favor troque para (/Cadastrar) para cadastrar novo carros";
    }

    @PostMapping("/Cadastrar")
    public ResponseEntity cadastrar(@RequestBody CarModels carModels, HttpServletRequest request) {
    var condicao=this.carRepository.findByCarro(carModels.getCarro());
        if (condicao!=null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Carro Ja existe");
        }   else {
            var hashcarro= BCrypt.withDefaults().hashToString(12, carModels.getCarro().toCharArray());
            carModels.setCarro(hashcarro);
            var carro = carRepository.save(carModels);
            return ResponseEntity.status(HttpStatus.CREATED).body(carro);
        }

    }
}

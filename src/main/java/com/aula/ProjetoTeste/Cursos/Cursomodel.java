package com.aula.ProjetoTeste.Cursos;

import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
@Entity(name = "Tabela_Curso")
public class Cursomodel {
    @Id
    @GeneratedValue(generator = "UUID")
    private UUID idcurso;
    private String nomecurso;
    private String tipo;
    public UUID getIdcurso() {
        return idcurso;
    }
    public void setIdcurso(UUID idcurso) {
        this.idcurso = idcurso;
    }
    public String getNomecurso() {
        return nomecurso;
    }
    public void setNomecurso(String nomecurso) {
        this.nomecurso = nomecurso;
    }
    public String getTipo() {
        return tipo;
    }
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
     
}

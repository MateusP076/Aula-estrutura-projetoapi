package com.aula.ProjetoTeste.User;

import java.util.UUID;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;


@Entity(name="TabelaUsuario")
public class UserModel {
    @Id
    @GeneratedValue(generator="UUID")
    private UUID iduser;
    private String nome;
    private String username;
    private String telefone;
    private String senha;
    public UUID getIduser() {
        return iduser;
    }
    public void setIduser(UUID iduser) {
        this.iduser = iduser;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getTelefone() {
        return telefone;
    }
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    public String getSenha() {
        return senha;
    }
    public void setSenha(String senha) {
        this.senha = senha;
    }
    
}

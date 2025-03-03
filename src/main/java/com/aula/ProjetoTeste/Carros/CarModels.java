package com.aula.ProjetoTeste.Carros;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.util.UUID;
@Entity(name = "Tabela_carros")
public class CarModels {
    @Id
    @GeneratedValue(generator = "UUID")
    private UUID idcarro;
    private String carro;
    private String marca;
    private String ano;
    private Double valor;
    private String iduser;

    public UUID getIdcarro() {
        return idcarro;
    }

    public void setIdcarro(UUID idcarro) {
        this.idcarro = idcarro;
    }

    public String getCarro() {
        return carro;
    }

    public void setCarro(String carro) {
        this.carro = carro;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }

    public String getIduser() {
        return iduser;
    }

    public void setIduser(String iduser) {
        this.iduser = iduser;
    }
}

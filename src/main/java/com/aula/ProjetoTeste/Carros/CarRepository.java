package com.aula.ProjetoTeste.Carros;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CarRepository extends JpaRepository<CarModels, UUID> {
    CarModels findByCarro(String carro);
}

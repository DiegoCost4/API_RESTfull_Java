package com.apirestfull.apirestfull.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.apirestfull.apirestfull.model.Cargos;

public interface CargoRepository extends JpaRepository<Cargos, Integer>{
    
}
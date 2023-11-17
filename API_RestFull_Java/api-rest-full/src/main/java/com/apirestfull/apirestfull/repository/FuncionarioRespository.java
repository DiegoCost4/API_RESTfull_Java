package com.apirestfull.apirestfull.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.apirestfull.apirestfull.model.Funcionario;

public interface FuncionarioRespository extends JpaRepository<Funcionario, Integer>{
    
}

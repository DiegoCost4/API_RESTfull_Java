package com.apirestfull.apirestfull.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.apirestfull.apirestfull.model.Usuarios;

public interface UsuarioRepository extends JpaRepository<Usuarios, Integer>{
    
}
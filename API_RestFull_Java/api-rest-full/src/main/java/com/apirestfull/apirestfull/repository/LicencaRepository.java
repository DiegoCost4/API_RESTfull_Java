package com.apirestfull.apirestfull.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.apirestfull.apirestfull.model.LicencaModel;

public interface LicencaRepository extends JpaRepository<LicencaModel, Long>{
    
}

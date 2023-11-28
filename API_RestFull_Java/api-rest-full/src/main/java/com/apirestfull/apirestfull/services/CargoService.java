package com.apirestfull.apirestfull.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apirestfull.apirestfull.model.Cargos;
import com.apirestfull.apirestfull.repository.CargoRepository;


@Service
public class CargoService {
    
    @Autowired
    private CargoRepository cargoRepository;

    /**
     * Metodo para retornar uma lista de cargos
     * @return lista de cargos
     */
    public List<Cargos> obterTodos(){
        return cargoRepository.findAll();
    }

    /**
     * Metodo que retorna o usuario encontrado pelo seu ID
     * @param id do usuario que será localizado
     * @return Retorna um usuario caso seja encontrado.
     */
    public Optional<Cargos> obterPorId(Integer id){
        //criar regras de negocio
        return cargoRepository.findById(id);
    }
    /**
     * Metodo para adicionar um usuario na lista
     * @param usuarios que será adicionado
     * @return retorna o usuario que foi adicionado na lista
     */
    public Cargos adicionar(Cargos cargos){

        //Criar regras de negocio
        return cargoRepository.save(cargos);
    }
    /**
     * Metodo para deletar o usuario por id
     * @param id do usuario a ser deletado.
     */
    public void deletar(Integer id){
        //Criar regra de negocio.
        cargoRepository.deleteById(id);
    }
    
    public Cargos atualizar(Integer id,Cargos cargos){
        //Criar regras de negocio.
        cargos.setId(id);

        return cargoRepository.save(cargos);
    }
    
}

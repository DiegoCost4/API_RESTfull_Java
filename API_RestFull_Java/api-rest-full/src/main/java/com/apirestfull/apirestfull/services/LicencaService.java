package com.apirestfull.apirestfull.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apirestfull.apirestfull.model.LicencaModel;
import com.apirestfull.apirestfull.repository.LicencaRepository;

@Service
public class LicencaService {

    @Autowired
    private LicencaRepository licencaRepository;

     /**
     * Metodo para retornar uma lista de usuarios
     * @return lista de usuarios
     */
    public List<LicencaModel> obterTodos(){
        return licencaRepository.findAll();
    }

        /**
     * Metodo que retorna o usuario encontrado pelo seu ID
     * @param id do usuario que será localizado
     * @return Retorna um usuario caso seja encontrado.
     */
    public Optional<LicencaModel> obterPorId(Long id){
        //criar regras de negocio
        return licencaRepository.findById(id);
    }

    /**
     * Metodo para adicionar um usuario na lista
     * @param usuarios que será adicionado
     * @return retorna o usuario que foi adicionado na lista
     */
    public LicencaModel adicionar(LicencaModel licencaModel){

        //Criar regras de negocio
        return licencaRepository.save(licencaModel);
    }
    /**
     * Metodo para deletar o usuario por id
     * @param id do usuario a ser deletado.
     */
    public void deletar(Long id){
        //Criar regra de negocio.
        licencaRepository.deleteById(id);
    }
    public LicencaModel atualizar(Long id,LicencaModel licencaModel){
        //Criar regras de negocio.
        licencaModel.setId(id);

        return licencaRepository.save(licencaModel);
    }


    
}

package com.apirestfull.apirestfull.services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.apirestfull.apirestfull.model.Funcionario;
import com.apirestfull.apirestfull.repository.FuncionarioRespository;



@Service
public class FuncionarioService {

    @Autowired
    private FuncionarioRespository fucionarioRepository;

    /**
     * Metodo para retornar uma lista de funcionario
     * @return lista de funcionario
     */
    public List<Funcionario> obterTodos(){
        //Criar regras de negocios.
        return fucionarioRepository.findAll();
    }

        /**
     * Metodo que retorna o funcionario encontrado pelo seu ID
     * @param id do funcionario que será localizado
     * @return Retorna um funcionario caso seja encontrado.
     */
    public Optional<Funcionario> obterPorId(Integer id){
        //Criar regras de negocios.
        return fucionarioRepository.findById(id);
    }

        /**
     * Metodo para adicionar funcionario na lista
     * @param funcionario que será adicionado
     * @return Retorna o funcionario que foi adicionado na lista.
     */
    public Funcionario adicionar(Funcionario funcionario){
        //Criar regras de negocios.
        return fucionarioRepository.save(funcionario);
    }

        /**
     * Metodo para deletar o funcionario por id
     * @param id do funcionario a ser deletado.
     */
    public void deletar(Integer id){
        //Criar regras de negocios.
        fucionarioRepository.deleteById(id);
    }

        /**
     * Metodo para atualizar funcionario na lista
     * @param funcionario após atualizar a lista
     * @param id do funcionario
     * @return
     */
    public Funcionario atualizar(Integer id,Funcionario funcionario){
        //Criar regras de negocios.
        //validação no id
        funcionario.setId(id);

        return fucionarioRepository.save(funcionario);
    }


}

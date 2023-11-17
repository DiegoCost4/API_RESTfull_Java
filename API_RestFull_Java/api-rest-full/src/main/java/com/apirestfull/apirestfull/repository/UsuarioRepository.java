package com.apirestfull.apirestfull.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;
import com.apirestfull.apirestfull.model.Usuarios;
import com.apirestfull.apirestfull.model.exception.ResourceNotFoundException;

@Repository
public class UsuarioRepository {
    
 //Simulando o banco de dados.
    private ArrayList<Usuarios> usuarios = new ArrayList<Usuarios>();
    private Integer ultimoId = 0;

    /**
     * Metodo para retornar uma lista de usuarios
     * @return lista de usuarios
     */
    public List<Usuarios> obterTodos(){
        return usuarios;
    }

    /**
     * Metodo que retorna o funcionario encontrado pelo seu ID
     * @param id do funcionario que será localizado
     * @return Retorna um funcionario caso seja encontrado.
     */
    public Optional<Usuarios> obterPorId(Integer id){
        return usuarios
                    .stream()
                    .filter(usuario -> usuario.getId() == id)
                    .findFirst();
    }

    /**
     * Metodo para adicionar funcionario na lista
     * @param usuario que será adicionado
     * @return Retornaro produto que foi adicionado na lista.
     */
    public Usuarios adicionar(Usuarios usuario){
        
        ultimoId++;
        usuario.setId(ultimoId);
        usuarios.add(usuario);

        return usuario;
    }

    /**
     * Metodo para deletar o funcionario por id
     * @param id do funcionario a ser deletado.
     */
    public void deletar(Integer id){
        usuarios.removeIf(usuario -> usuario.getId() == id);
    }

    /**
     * Metodo para atualizar funcionario na lista
     * @param usuario após atualizar a lista
     * @return
     */
    public Usuarios atualizar(Usuarios usuario){
        Optional<Usuarios> usuarioEncontrado = obterPorId(usuario.getId());

        if(usuarioEncontrado.isEmpty()){
            throw new ResourceNotFoundException("usuario não encontrado");
        }

        deletar(usuario.getId());
        usuarios.add(usuario);
        return usuario;

    }
}

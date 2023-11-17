package com.apirestfull.apirestfull.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apirestfull.apirestfull.model.Usuarios;
import com.apirestfull.apirestfull.repository.UsuarioRepository;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    /**
     * Metodo para retornar uma lista de usuarios
     * @return lista de usuarios
     */
    public List<Usuarios> obterTodos(){
        return usuarioRepository.obterTodos();
    }

    /**
     * Metodo que retorna o usuario encontrado pelo seu ID
     * @param id do usuario que será localizado
     * @return Retorna um usuario caso seja encontrado.
     */
    public Optional<Usuarios> obterPorId(Integer id){
        //criar regras de negocio
        return usuarioRepository.obterPorId(id);
    }
    /**
     * Metodo para adicionar um usuario na lista
     * @param usuarios que será adicionado
     * @return retorna o usuario que foi adicionado na lista
     */
    public Usuarios adicionar(Usuarios usuarios){

        //Criar regras de negocio
        return usuarioRepository.adicionar(usuarios);
    }
    /**
     * Metodo para deletar o usuario por id
     * @param id do usuario a ser deletado.
     */
    public void deletar(Integer id){
        //Criar regra de negocio.
        usuarioRepository.deletar(id);
    }
    
    public Usuarios atualizar(Integer id,Usuarios usuarios){
        //Criar regras de negocio.
        usuarios.setId(id);

        return usuarioRepository.atualizar(usuarios);
    }




    
}

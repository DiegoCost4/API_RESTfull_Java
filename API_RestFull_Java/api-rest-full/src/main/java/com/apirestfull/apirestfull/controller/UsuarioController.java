package com.apirestfull.apirestfull.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.apirestfull.apirestfull.model.Usuarios;
import com.apirestfull.apirestfull.services.UsuarioService;

    @RestController
    @RequestMapping("/api/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public List<Usuarios> obterTodos(){
        return usuarioService.obterTodos();
    }

    @GetMapping("/{id}")
    public Optional<Usuarios> obterPorId(@PathVariable Integer id){
        return usuarioService.obterPorId(id);
    }

    @PostMapping
    public Usuarios adicionar(@RequestBody Usuarios usuarios){
        return usuarioService.adicionar(usuarios);
    }

    @DeleteMapping("/{id}")
    public String deletar(@PathVariable Integer id){
        usuarioService.deletar(id);
        return "Usuario com id: " + id + " Foi deletado!";
    }

    @PutMapping("/{id}")
    public Usuarios atualizar(@RequestBody Usuarios usuarios, @PathVariable Integer id){
        return usuarioService.atualizar(id, usuarios);
    }


}

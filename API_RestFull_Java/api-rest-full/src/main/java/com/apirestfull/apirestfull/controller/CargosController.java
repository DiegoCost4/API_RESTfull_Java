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

import com.apirestfull.apirestfull.model.Cargos;
import com.apirestfull.apirestfull.services.CargoService;

    @RestController
    @RequestMapping("/api/cargos")
public class CargosController {
    @Autowired
    private CargoService cargosService;

    @GetMapping
    public List<Cargos> obterTodos(){
        return cargosService.obterTodos();
    }

    @GetMapping("/{id}")
    public Optional<Cargos> obterPorId(@PathVariable Integer id){
        return cargosService.obterPorId(id);
    }

    @PostMapping
    public Cargos adicionar(@RequestBody Cargos cargos){
        return cargosService.adicionar(cargos);
    }

    @DeleteMapping("/{id}")
    public String deletar(@PathVariable Integer id){
        cargosService.deletar(id);
        return "Cargo com id: " + id + " Foi removido!";
    }

    @PutMapping("/{id}")
    public Cargos atualizar(@RequestBody Cargos cargos, @PathVariable Integer id){
        return cargosService.atualizar(id, cargos);
    }
}

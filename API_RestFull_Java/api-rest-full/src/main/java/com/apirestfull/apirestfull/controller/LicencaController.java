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

import com.apirestfull.apirestfull.model.LicencaModel;
import com.apirestfull.apirestfull.services.LicencaService;


@RestController
    @RequestMapping("/api/licenca")
public class LicencaController {

    @Autowired
    private LicencaService licencaService;

    @GetMapping
    public List<LicencaModel> obterTodos(){
        return licencaService.obterTodos();
    }

    @GetMapping("/{id}")
    public Optional<LicencaModel> obterPorId(@PathVariable Long id){
        return licencaService.obterPorId(id);
    }

    @PostMapping
    public LicencaModel adicionar(@RequestBody LicencaModel licencaModel){
        return licencaService.adicionar(licencaModel);
    }

    @DeleteMapping("/{id}")
    public String deletar(@PathVariable Long id){
        licencaService.deletar(id);
        return "Usuario com id: " + id + " Foi deletado!";
    }

    @PutMapping("/{id}")
    public LicencaModel atualizar(@RequestBody LicencaModel licencaModel, @PathVariable Long id){
        return licencaService.atualizar(id, licencaModel);
    }
}

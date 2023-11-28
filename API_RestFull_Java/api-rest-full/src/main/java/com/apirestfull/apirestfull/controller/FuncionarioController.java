package com.apirestfull.apirestfull.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.apirestfull.apirestfull.model.Funcionario;
import com.apirestfull.apirestfull.services.FuncionarioService;

@RestController
@RequestMapping("/api/funcionarios")
public class FuncionarioController {

    @Autowired
    private FuncionarioService funcionarioService;

    @GetMapping
    public List<Funcionario> obterTodos(){
        return funcionarioService.obterTodos();
    }

    @GetMapping("/{id}")
    public Optional<Funcionario> obterPorId(@PathVariable Integer id){
        return funcionarioService.obterPorId(id);
    }     
    // public Funcionario adicionar(@RequestBody Funcionario funcionario){
    //     return funcionarioService.adicionar(funcionario);
    // }
    @PostMapping
    public ResponseEntity<Funcionario> adicionar(@RequestBody Funcionario funcionario) {
        try {
            // Adicione lógica para calcular INSS, imposto de renda, horas extras, etc.
            calcularValores(funcionario);
    
            // Adicione ou atualize o funcionário
            Funcionario funcionarioSalvo = funcionarioService.adicionar(funcionario);
    
            return new ResponseEntity<>(funcionarioSalvo, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    public String deletar(@PathVariable Integer id){
        funcionarioService.deletar(id);
        return "Fucionario com id:" + id + "foi deletado com sucesso";
    }

    // @PutMapping("/{id}")
    // public Funcionario atualizar(@RequestBody Funcionario funcionario, @PathVariable Integer id){
    //     return funcionarioService.atualizar(id, funcionario);
    // }
    @PutMapping("/{id}")
    public Funcionario atualizar(@RequestBody Funcionario funcionario, @PathVariable Integer id) {
        // Obtenha o funcionário existente
        Optional<Funcionario> optionalFuncionario = funcionarioService.obterPorId(id);

        if (optionalFuncionario.isPresent()) {
            Funcionario funcionarioExistente = optionalFuncionario.get();

            // Atualize os campos modificáveis
            funcionarioExistente.setName(funcionario.getName());
            funcionarioExistente.setCpf(funcionario.getCpf());
            funcionarioExistente.setAdress(funcionario.getAdress());
            funcionarioExistente.setPhone(funcionario.getPhone());
            funcionarioExistente.setOffice(funcionario.getOffice());
            funcionarioExistente.setSalary(funcionario.getSalary());
            funcionarioExistente.setObservation(funcionario.getObservation());
            funcionarioExistente.setHorasExtrasTrabalhadas(funcionario.getHorasExtrasTrabalhadas());

            // Adicione lógica para calcular INSS, imposto de renda, horas extras, etc.
            calcularValores(funcionarioExistente);

            // Atualize o funcionário
            return funcionarioService.atualizar(id, funcionarioExistente);
        } else {
            return null;
        }
    }
    private void calcularValores(Funcionario funcionario) {
        double inss = funcionarioService.calcularINSS(funcionario.getSalary());
        double impostoRenda = funcionarioService.calcularImpostoRenda(funcionario.getSalary());
        double horasExtras = funcionarioService.calcularHorasExtras(funcionario, 10); // Exemplo: 10 horas extras
        double salarioTotal = funcionarioService.calcularSalarioTotal(funcionario, horasExtras);
    
        // Atribua os cálculos ao funcionário
        funcionario.setInss(inss);
        funcionario.setImpostoRenda(impostoRenda);
        funcionario.setHorasExtrasTrabalhadas((float) horasExtras);
        funcionario.setSalarioTotal(salarioTotal);
    }
}

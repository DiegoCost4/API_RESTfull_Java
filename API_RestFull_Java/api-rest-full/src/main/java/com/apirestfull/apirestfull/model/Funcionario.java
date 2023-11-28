package com.apirestfull.apirestfull.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Funcionario {
    //#region atributos
    @Id 
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String name;

    private Long cpf;

    private String adress;

    private String phone;

    private String office;

    private Float salary;

    private String observation;

    private String tipo;

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    private LocalDate dataInicio;

    private LocalDate dataFim;

    public LocalDate getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(LocalDate dataInicio) {
        this.dataInicio = dataInicio;
    }

    public LocalDate getDataFim() {
        return dataFim;
    }

    public void setDataFim(LocalDate dataFim) {
        this.dataFim = dataFim;
    }

    @Column(name = "salario_liquido")
    private double salarioLiquido;

    @Column(name = "imposto_renda")
    private double impostoRenda;

    @Column(name = "inss")
    private double inss;

    @Column(name = "horas_extras_trabalhadas")
    private Float horasExtrasTrabalhadas;
    
    @Column(name = "salario_total")
    private double salarioTotal;
    //#endregion 

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getCpf() {
        return cpf;
    }

    public void setCpf(Long cpf) {
        this.cpf = cpf;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getOffice() {
        return office;
    }

    public void setOffice(String office) {
        this.office = office;
    }

    public Float getSalary() {
        return salary;
    }

    public void setSalary(Float salary) {
        this.salary = salary;
    }

    public String getObservation() {
        return observation;
    }

    public void setObservation(String observation) {
        this.observation = observation;
    }

    public double getSalarioLiquido() {
        return salarioLiquido;
    }

    public void setSalarioLiquido(double salarioLiquido) {
        this.salarioLiquido = salarioLiquido;
    }

    public double getImpostoRenda() {
        return impostoRenda;
    }

    public void setImpostoRenda(double impostoRenda) {
        this.impostoRenda = impostoRenda;
    }

    public double getInss() {
        return inss;
    }

    public void setInss(double inss) {
        this.inss = inss;
    }

    public Float getHorasExtrasTrabalhadas() {
        return horasExtrasTrabalhadas;
    }

    public void setHorasExtrasTrabalhadas(Float horasExtrasTrabalhadas) {
        this.horasExtrasTrabalhadas = horasExtrasTrabalhadas;
    }

    public double getSalarioTotal() {
        return salarioTotal;
    }

    public void setSalarioTotal(double salarioTotal) {
        this.salarioTotal = salarioTotal;
    }




    
}

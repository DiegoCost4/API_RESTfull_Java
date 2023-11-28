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
     /**
     * Método para calcular o salário líquido de um usuário
     * @param id do usuário para o qual calcular o salário líquido
     * @return Retorna um objeto de usuário com informações de salário atualizadas.
     */
    public Funcionario calcularSalario(Integer id) {
        Optional<Funcionario> optionalFuncionario = fucionarioRepository.findById(id);

        if (optionalFuncionario.isPresent()) {
            Funcionario funcionario = optionalFuncionario.get();
            double salarioBruto = funcionario.getSalary();

            double salarioLiquido = calcularSalarioLiquido(salarioBruto);
            funcionario.setSalarioLiquido(salarioLiquido);

            double ir = calcularImpostoRenda(salarioBruto);
            funcionario.setImpostoRenda(ir);

            double inss = calcularINSS(salarioBruto);
            funcionario.setInss(inss);

            double horasExtras = calcularHorasExtras(funcionario, 10); // Exemplo: 10 horas extras
            funcionario.setHorasExtrasTrabalhadas((float) horasExtras);

            double salarioTotal = calcularSalarioTotal(funcionario, horasExtras);
            funcionario.setSalarioTotal(salarioTotal);

            fucionarioRepository.save(funcionario);

            return funcionario;
        } else {
            return null;
        }
    }

    private double calcularSalarioLiquido(double salarioBruto) {
        return 0;
    }

    public double calcularImpostoRenda(double salarioBruto) {
        // Cálculo do Imposto de Renda
        double[] faixas = { 1903.98, 2826.65, 3751.05, 4664.68, 5594.92 };
        double[] aliquotas = { 0.075, 0.15, 0.225, 0.275, 0.3 };
        double deducao = 142.80;

        double salarioBase = salarioBruto - calcularINSS(salarioBruto);
        double ir = 0;

        for (int i = 0; i < faixas.length; i++) {
            if (salarioBase <= faixas[i]) {
                ir += (salarioBase * aliquotas[i]) - deducao;
                break;
            } else {
                ir += (faixas[i] * aliquotas[i]) - deducao;
                salarioBase -= faixas[i];
            }
        }

        return ir;
    }

    public double calcularINSS(double salarioBruto) {
        // Cálculo do INSS
        double[] faixas = { 1045.00, 2089.60, 3134.40, 6101.06 };
        double[] aliquotas = { 0.075, 0.09, 0.12, 0.14 };

        double inss = 0;

        for (int i = 0; i < faixas.length; i++) {
            if (salarioBruto <= faixas[i]) {
                inss += salarioBruto * aliquotas[i];
                break;
            } else {
                inss += faixas[i] * aliquotas[i];
                salarioBruto -= faixas[i];
            }
        }

        return inss;
    }

    public double calcularHorasExtras(Funcionario funcionario, int horasExtrasTrabalhadas) {
        // Exemplo: Suponha que as horas extras são pagas com um adicional de 50% sobre a hora normal.
        double valorHoraNormal = funcionario.getSalary() / (4 * 5); // Salário dividido por 4 semanas e 5 dias por semana
        double valorHorasExtras = horasExtrasTrabalhadas * 1.5 * valorHoraNormal; // Adicional de 50%

        return valorHorasExtras;
    }

    public double calcularSalarioTotal(Funcionario funcionario, double horasExtras) {
        // Se necessário, você pode validar se o funcionário é nulo ou possui um ID válido antes de prosseguir.

        // Outros cálculos necessários, se houver

        double salarioTotal = funcionario.getSalary() + horasExtras;

        // Atualize o objeto do usuário com as informações do salário total
        funcionario.setSalarioLiquido(salarioTotal);
        fucionarioRepository.save(funcionario);

        return salarioTotal;
    }

    public double calcularHorasExtras(double horasExtras) {
        return 0;
    }
    
    

}

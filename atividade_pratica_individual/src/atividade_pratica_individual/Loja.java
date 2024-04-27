package atividade_pratica_individual;

import java.util.ArrayList;
import java.util.List;

public class Loja {
    private Conta conta;
    private List<Funcionario> funcionarios;

    public Loja(Conta conta) {
        this.conta = conta;
        this.funcionarios = new ArrayList<>();
    }

    public Conta getConta() {
        return conta;
    }

    public void adicionarFuncionario(Funcionario funcionario) {
        funcionarios.add(funcionario);
    }

    public void pagarSalarios() {
        double totalSalarios = funcionarios.size() * 1400.0;
        if (conta.getSaldo() >= totalSalarios) {
            for (Funcionario funcionario : funcionarios) {
                funcionario.getSalarioLoja().depositar(1400.0);
                conta.sacar(1400.0);
            }
            System.out.println("Salários dos funcionários pagos.");
        } else {
            System.out.println("Saldo insuficiente para pagar os salários dos funcionários.");
        }
    }
}

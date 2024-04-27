package atividade_pratica_individual;

public class Funcionario extends Thread {
    private Conta salarioLoja;
    private Conta investimentos;

    public Funcionario(Conta salarioLoja, Conta investimentos) {
        this.salarioLoja = salarioLoja;
        this.investimentos = investimentos;
    }

    public Conta getSalarioLoja() {
        return salarioLoja;
    }

    @Override
    public void run() {
        double salario = 1400.0;
        double valorInvestimento = salario * 0.2;
        salarioLoja.sacar(salario);
        investimentos.depositar(valorInvestimento);
        System.out.println("Funcionário recebeu o salário e investiu R$ " + valorInvestimento);
    }
}

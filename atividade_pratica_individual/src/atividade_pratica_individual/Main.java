package atividade_pratica_individual;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.Random;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
    	
    	SistemaFinanceiro sistemaFinanceiro = new SistemaFinanceiro();
    	Conta contaBanco = new Conta(0); 
     
        Conta[] contasClientes = new Conta[5];
        for (int i = 0; i < contasClientes.length; i++) {
            contasClientes[i] = new Conta(1000); 
        }

        Conta contaLoja1 = new Conta(0);
        Conta contaLoja2 = new Conta(0); 
       
        Conta contaInvestimentosFuncionario1 = new Conta(0); 
        Conta contaInvestimentosFuncionario2 = new Conta(0); 
        Conta contaInvestimentosFuncionario3 = new Conta(0); 
        Conta contaInvestimentosFuncionario4 = new Conta(0); 
        Conta contaInvestimentosFuncionario5 = new Conta(0);
       
        Loja loja1 = new Loja(contaLoja1);
        Loja loja2 = new Loja(contaLoja2);
      
        Funcionario funcionario1 = new Funcionario(contaLoja1, contaInvestimentosFuncionario1);
        Funcionario funcionario2 = new Funcionario(contaLoja1, contaInvestimentosFuncionario2);
        Funcionario funcionario3 = new Funcionario(contaLoja2, contaInvestimentosFuncionario3);
        Funcionario funcionario4 = new Funcionario(contaLoja2, contaInvestimentosFuncionario4);
        Funcionario funcionario5 = new Funcionario(contaLoja1, contaInvestimentosFuncionario5);
       
        loja1.adicionarFuncionario(funcionario1);
        loja1.adicionarFuncionario(funcionario2);
        loja1.adicionarFuncionario(funcionario5);
        loja2.adicionarFuncionario(funcionario3);
        loja2.adicionarFuncionario(funcionario4);
        
        Cliente[] clientes = new Cliente[5];
        for (int i = 0; i < clientes.length; i++) {
            clientes[i] = new Cliente(contasClientes[i], new Loja[]{loja1, loja2});
        }

        ExecutorService executorService = Executors.newCachedThreadPool();
        for (Cliente cliente : clientes) {
            executorService.execute(cliente);
        }
        executorService.execute(funcionario1);
        executorService.execute(funcionario2);
        executorService.execute(funcionario3);
        executorService.execute(funcionario4);
        executorService.execute(funcionario5);
     
        executorService.shutdown();
        while (!executorService.isTerminated()) {
          
        }
    
        sistemaFinanceiro.transferir(contaBanco, loja1.getConta(), 1400.0);
        sistemaFinanceiro.transferir(contaBanco, loja2.getConta(), 1400.0);

        System.out.println("Saldo final da conta do banco: " + contaBanco.getSaldo());
        System.out.println("Saldo final da conta da loja 1: " + contaLoja1.getSaldo());
        System.out.println("Saldo final da conta da loja 2: " + contaLoja2.getSaldo());
        System.out.println("Saldo final dos investimentos do funcionário 1: " + contaInvestimentosFuncionario1.getSaldo());
        System.out.println("Saldo final dos investimentos do funcionário 2: " + contaInvestimentosFuncionario2.getSaldo());
        System.out.println("Saldo final dos investimentos do funcionário 3: " + contaInvestimentosFuncionario3.getSaldo());
        System.out.println("Saldo final dos investimentos do funcionário 4: " + contaInvestimentosFuncionario4.getSaldo());
        System.out.println("Saldo final dos investimentos do funcionário 5: " + contaInvestimentosFuncionario5.getSaldo());
    }
}
package atividade_pratica_individual;

import java.util.Random;

public class Cliente extends Thread {
    private Conta conta;
    private Loja[] lojas;

    public Cliente(Conta conta, Loja[] lojas) {
        this.conta = conta;
        this.lojas = lojas;
    }

    @Override
    public void run() {
        Random random = new Random();
        while (conta.getSaldo() > 0) {
            int valorCompra = random.nextBoolean() ? 100 : 200;
            Loja loja = lojas[random.nextInt(lojas.length)];
            synchronized (loja) {
                if (conta.getSaldo() >= valorCompra) {
                    conta.sacar(valorCompra);
                    loja.getConta().depositar(valorCompra);
                    System.out.println("Cliente realizou compra de R$ " + valorCompra + " na loja " + loja);
                }
            }
        }
    }
}

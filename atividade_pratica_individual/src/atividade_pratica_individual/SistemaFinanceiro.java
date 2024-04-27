package atividade_pratica_individual;

public class SistemaFinanceiro {
    public synchronized void transferir(Conta origem, Conta destino, double valor) {
        origem.sacar(valor);
        destino.depositar(valor);
        System.out.println("Transferência de " + valor + " realizada de " + origem + " para " + destino);
    }
}

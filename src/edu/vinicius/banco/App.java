package edu.vinicius.banco;

import java.util.List;

import edu.vinicius.banco.contas.Conta;

public class App {
    public static void main(String[] args) {
        Banco banco = new Banco("Banese", "Centro");

        Cliente c1 = new Cliente("Joao", "Vinicius");
        Cliente c2 = new Cliente("Ruby", "Rose");
        Cliente c3 = new Cliente("Cleiton", "Rasta");
        Cliente c4 = new Cliente("Cabeça", "de Gelo");

        banco.criarContaCorrente(c1);
        banco.criarContaCorrente(c2);
        banco.criarContaPoupanca(c3);
        banco.criarContaCorrente(c4);

        /* Exibir contas
        Consumer<Conta> contaConsumer = c -> {
            System.out.printf("%s %s :: %s-%d%n", c.getCliente().getNome(), c.getCliente().getSobrenome(), c.getAgencia(), c.getNumeroConta());
        };
        banco.getContas().forEach(contaConsumer);
        */

        List<Conta> contas = banco.getContas();

        contas.get(0).depositar(100);
        contas.get(1).depositar(200);
        contas.get(1).transferir(50, contas.get(0));
        contas.get(2).depositar(300);
        contas.get(2).sacar(500);
        contas.get(1).sacar(50);
        contas.get(0).transferir(20, contas.get(3));
    }
}

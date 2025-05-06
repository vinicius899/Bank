package edu.vinicius.banco.contas;

import java.util.Random;

import edu.vinicius.banco.Cliente;

public abstract class Conta {
    private Random rand = new Random(); 
    private static int numeroBase = 0;

    private String agencia;
    private int numeroConta;
    private double saldo;
    private Cliente cliente;
     
    protected Conta(Cliente cliente) {
        this.agencia = String.format("%05d", Math.abs(rand.nextInt() % 100));
        this.numeroConta = Conta.numeroBase++;
        this.cliente = cliente;
        this.saldo = 0;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public String getAgencia() {
        return agencia;
    }

    public int getNumeroConta() {
        return numeroConta;
    }

    public double getSaldo() {
        return saldo;
    }

    public void sacar(double valor) {
        if (this.saldo >= valor) {
            this.saldo -= valor;
            System.out.printf("Saque realizado: %.2f%n", valor);
        } else {
            System.out.println("Saldo insuficiente");
        }
        exibirSaldo();
    }

    public void depositar(double valor) {
        this.saldo += valor;
        System.out.printf("Deposito realizado: %.2f%n", valor);
        exibirSaldo();
    }

    public void transferir(double valor, Conta contaDestino) {
        this.sacar(valor);
        contaDestino.depositar(valor);
        System.out.println("Transferencia bem sucedida");
        exibirSaldo();
    }

    private void exibirSaldo() {
        System.out.printf("Saldo atual: %.2f%n", getSaldo());
    }
}

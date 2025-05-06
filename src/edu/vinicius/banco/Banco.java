package edu.vinicius.banco;

import java.util.ArrayList;
import java.util.List;

import edu.vinicius.banco.contas.Conta;
import edu.vinicius.banco.contas.ContaCorrente;
import edu.vinicius.banco.contas.ContaPoupanca;

public class Banco {
    private String nome;
    private String endereco;
    private List<Conta> contas;

    public Banco(String nome, String endereco) {
        this.nome = nome;
        this.endereco = endereco;
        this.contas = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public List<Conta> getContas() {
        return contas;
    }

    public void criarContaCorrente(Cliente cliente) {
        Conta conta = new ContaCorrente(cliente);
        this.contas.add(conta);
    }

    public void criarContaPoupanca(Cliente cliente) {
        Conta conta = new ContaPoupanca(cliente);
        this.contas.add(conta);
    }
}

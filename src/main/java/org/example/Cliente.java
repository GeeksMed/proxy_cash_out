package org.example;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

public class Cliente implements ICliente{
    private String cpf;
    private String primeiroNome;
    private String ultimoNome;
    private String agencia;
    private String conta;
    private Double saldo;

    public Cliente(String cpf){
        this.cpf = cpf;
        Cliente objeto = BD.getCliente(cpf);
        this.primeiroNome = objeto.primeiroNome;
        this.ultimoNome = objeto.ultimoNome;
        this.agencia = objeto.agencia;
        this.conta = objeto.conta;
        this.saldo = objeto.saldo;
    }

    public Cliente(String cpf, String primeiroNome, String ultimoNome, String agencia, String conta, Double saldo){
        this.cpf = cpf;
        this.primeiroNome = primeiroNome;
        this.ultimoNome = ultimoNome;
        this.agencia = agencia;
        this.conta = conta;
        this.saldo = saldo;
    }

    public String getCpf() {return this.cpf;}

    @Override
    public List<String> obterDados() {
        return Arrays.asList(this.primeiroNome, this.ultimoNome, this.agencia, this.conta);
    }

    @Override
    public List<Double> obterSaldoConta() {
        return Arrays.asList(this.saldo);
    }

    @Override
    public List<String> obterInformacoes(Funcionario funcionario) {
        return Arrays.asList(this.primeiroNome, this.ultimoNome, this.agencia, this.conta, String.valueOf(this.saldo));
    }
}

package org.example;

import org.jetbrains.annotations.NotNull;

import java.io.Serializable;
import java.util.List;

public class ClienteProxy implements ICliente{
    private Cliente cliente;

    private String cpf;

    public ClienteProxy(String cpf) {this.cpf = cpf;}

    @Override
    public List<String> obterDados() {
        if (this.cliente == null) {
            this.cliente = new Cliente(this.cpf);
        }
        return this.cliente.obterDados();
    }

    @Override
    public List<Double> obterSaldoConta() {
        if (this.cliente == null) {
            this.cliente = new Cliente(this.cpf);
        }
        return this.cliente.obterSaldoConta();
    }
    @Override
    public List<String> obterInformacoes(@NotNull Funcionario funcionario) {
        if (!funcionario.isAdministrador()) {
            throw new IllegalArgumentException("Funcionário não autorizado");
        }
        if (this.cliente == null) {
            this.cliente = new Cliente(this.cpf);
        }
        return this.cliente.obterInformacoes(funcionario);
    }
}

package org.example;

import java.io.Serializable;
import java.util.List;

public interface ICliente {
    public List<String> obterDados();
    public List<Double> obterSaldoConta();
    public List<String> obterInformacoes(Funcionario funcionario);
}

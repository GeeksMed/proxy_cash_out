package org.example;

import java.util.HashMap;
import java.util.Map;

public class BD {
    private static Map<String, Cliente> clientes = new HashMap<>();

    public static Cliente getCliente(String cpf) {return clientes.get(cpf);}

    public static void addCliente(Cliente cliente) { clientes.put(cliente.getCpf(), cliente);}
}

package org.example;

import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AlunoProxyTest {

    @BeforeEach
    void setUp() {
        BD.addCliente(new Cliente("00000000000", "João", "Jon", "0001", "1234", 0.11));
        BD.addCliente(new Cliente("00000000001", "Maria", "Mari", "0001", "9876", 100000000.0));
    }

    @Test
    void deveRetornarDadosCliente() {
        ClienteProxy cliente = new ClienteProxy("00000000000");

        assertEquals(Arrays.asList("João", "Jon", "0001", "1234"), cliente.obterDados());
    }

    @Test
    void deveRetonarSaldoConta() {
        ClienteProxy cliente = new ClienteProxy("00000000001");

        assertEquals(Arrays.asList(100000000.0), cliente.obterSaldoConta());
    }

    @Test
    void deveRetonarInformacoes() {
        Funcionario funcionario = new Funcionario("Ana", true);
        ClienteProxy cliente = new ClienteProxy("00000000000");

        assertEquals(Arrays.asList("João", "Jon", "0001", "1234", "0.11"), cliente.obterInformacoes(funcionario));
    }

    @Test
    void deveRetonarExcecaoUsuarioNaoAutorizadoRetonarInformacoes() {
        try {
            Funcionario funcionario = new Funcionario("Joana", false);
            ClienteProxy cliente = new ClienteProxy("00000000000");

            cliente.obterInformacoes(funcionario);
            fail();
        }
        catch (IllegalArgumentException e) {
            assertEquals("Funcionário não autorizado", e.getMessage());
        }
    }
}


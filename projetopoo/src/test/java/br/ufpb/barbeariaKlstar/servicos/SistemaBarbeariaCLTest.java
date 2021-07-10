package br.ufpb.barbeariaKlstar.servicos;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.ufpb.pacote.code.entidades.Cliente;
import br.ufpb.pacote.code.servicos.SistemaBarbeariaCL;


public class SistemaBarbeariaCLTest {

    SistemaBarbeariaCL sistema;

    @BeforeEach
    void setUp() {
        sistema = new SistemaBarbeariaCL();
    }

    @Test
    void testCadastrarFuncionario() {
    	
        assertTrue(sistema.cadastrarFuncionario("Samuel", "18/11/2000", "8399182", "samuel@email", "708534"));
        assertFalse(sistema.cadastrarFuncionario("Samuel", "18/11/2000", "8399182", "samuel@email", "708534"));

        assertTrue(sistema.cadastrarFuncionario("Maria", "18/11/2001", "839918434534", "maria@email", "707234"));
        assertFalse(sistema.cadastrarFuncionario("123", "18/11/2000", "83991843567", "maria@email", "707"));
        assertFalse(sistema.cadastrarFuncionario("João", "18/11/2000", "wasd", "joao@email", "708"));
        assertFalse(sistema.cadastrarFuncionario("Pedro", "18/11/2000", "083991743655", "pedro@email", "qwe"));

    }

    @Test
    void testPesquisaFuncionarioPorNome() {
        assertEquals(0, sistema.pesquisaFuncionarioPorNome("Carlos").size());
        sistema.cadastrarFuncionario("Maria Luiza", "18/11/2000", "83991843567", "mariaLuiza@email", "707");
        sistema.cadastrarFuncionario("Maria Clara", "17/04/2002", "83991843346", "mariaClara@email", "708");
        sistema.cadastrarFuncionario("Pedro", "18/11/2000", "083991743655", "pedro@email", "708");
        
        assertEquals(2, sistema.pesquisaFuncionarioPorNome("maria").size());
        assertEquals(1, sistema.pesquisaFuncionarioPorNome("maria clara").size());

    }

    @Test
    void testCadastrarCliente() {
        assertTrue(sistema.cadastrarCliente("Maria", "83991843567", "maria@email"));
        assertFalse(sistema.cadastrarCliente("Maria", "83991843567", "maria@email"));

        assertFalse(sistema.cadastrarCliente("123", "83991843567", "marial@email"));
        assertFalse(sistema.cadastrarCliente("Sergio", "wasd", "sergio@email"));
    }

    @Test
    void testPesquisaClientePorTelefone() {
        Cliente user = sistema.pesquisarCliente("083993521644");
        if (user != null) {fail("Não deveria retornar nenhum cliente");}

        sistema.cadastrarCliente("Samuel Almeida", "083993521644", "samuel@email");
        sistema.cadastrarCliente("Samuel Henrique", "083993521645", "samuel@email");
        sistema.cadastrarCliente("Francisco", "081991743566", "francisco@email");

        Cliente user2 = sistema.pesquisarCliente("083993521644");
        assertEquals("Samuel Almeida", user2.getNome());
    } 

    @Test
    void testPesquisarTodosClientes() {
    	assertEquals(0, sistema.pesquisarTodosClientes().size());
    	sistema.cadastrarCliente("Samuel Almeida", "083993521644", "samuel@email");
        sistema.cadastrarCliente("Samuel Henrique", "083993521645", "samuel@email");
        sistema.cadastrarCliente("Francisco", "081991743566", "francisco@email");
        assertEquals(3, sistema.pesquisarTodosClientes().size());
    }

}

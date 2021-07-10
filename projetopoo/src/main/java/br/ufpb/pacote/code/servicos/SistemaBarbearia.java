package br.ufpb.pacote.code.servicos;

import java.util.Collection;
import java.util.HashMap;

import br.ufpb.pacote.code.Horario.AgendaDeHorarios;
import br.ufpb.pacote.code.entidades.Cliente;
import br.ufpb.pacote.code.entidades.Funcionario;

public interface SistemaBarbearia {

    public HashMap<String, Cliente> pesquisarTodosClientes();

    public boolean cadastrarFuncionario(String nome, String dataDeNascimento, String telefone, String email, String cpf);

    public boolean existeFuncionario(String cpf);

    //public boolean agendarHorario(String hora, AgendaDeHorarios horario);

    public Collection<Funcionario> pesquisaFuncionarioPorNome(String nome);

    public boolean cadastrarCliente(String nome, String telefone, String email);

    public boolean existeCliente(String telefone);


    public Cliente pesquisarCliente(String telefone);

    public void gravarDados();

    public void recuperarDados();

}

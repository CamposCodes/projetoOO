package aula.lojaoculos.model;

import aula.lojaoculos.persistence.DadosDeCodigosPersistence;

import java.util.Date;

public class Funcionario extends Pessoa {

    private String cargo;
    private final int codigo;
    private final String login;
    private final String senha;


    public Funcionario(String nome, Date dtnasc, String email, String cpf, String telefone, String cargo, int codigo, String login, String senha) {
        super(nome, dtnasc, email, cpf, telefone);
        this.cargo = cargo;
        this.codigo = codigo;
        this.login = login;
        this.senha = senha;
        DadosDeCodigosPersistence persistence = new DadosDeCodigosPersistence();
        DadosDeCodigos codigos = persistence.get();
        codigo = codigos.getCodigoFuncionario();
        codigos.setCodigoFuncionario(codigo + 1);
        persistence.save(codigos);
    }

}

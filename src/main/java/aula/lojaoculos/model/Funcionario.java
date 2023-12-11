package aula.lojaoculos.model;

import java.util.Date;

public class Funcionario extends Pessoa {

    private String cargo;
    private final int codigo;
    private String login;
    private String senha;


    public Funcionario(String nome, Date dtnasc, String email, String cpf, String telefone, String cargo, int codigo, String login, String senha) {
        super(nome, dtnasc, email, cpf, telefone);
        this.cargo = cargo;
        this.codigo = codigo;
        this.login = login;
        this.senha = senha;
    }

}

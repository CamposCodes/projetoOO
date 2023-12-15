package aula.lojaoculos.model;

import java.util.Date;

public abstract class Pessoa {
    protected String nome;
    protected Date dtNasc;
    protected String email;
    protected String cpf;
    protected String telefone;
    public Pessoa(String nome, Date dtNasc, String email, String cpf, String telefone){
        this.nome = nome;
        this.dtNasc = dtNasc;
        this.email = email;
        this.cpf = cpf;
        this.telefone = telefone;
    }

    public String getCpf() {
        return this.cpf;
    }

    public String getNome() {return this.nome;}
}

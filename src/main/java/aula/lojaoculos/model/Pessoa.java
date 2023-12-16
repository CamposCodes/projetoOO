package aula.lojaoculos.model;

import java.util.Date;

public abstract class Pessoa {
    protected String nome;
    protected Date dtNasc;

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getDtNasc() {
        return dtNasc;
    }

    public void setDtNasc(Date dtNasc) {
        this.dtNasc = dtNasc;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

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

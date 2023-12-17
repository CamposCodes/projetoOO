/*Integrantes:
   - Gabriel Campos (202176005)
   - Álvaro Thees (202165003A)
*/
package aula.lojaoculos.model;

import aula.lojaoculos.persistence.DadosDeCodigosPersistence;

import java.util.Date;

public class Cliente extends Pessoa{

    int codigo;
    double creditosNaLoja;
    public Cliente(String nome, Date dtnasc, String email, String cpf, String telefone) {
        super(nome, dtnasc, email, cpf, telefone);
        creditosNaLoja = 0;
        DadosDeCodigosPersistence persistence = new DadosDeCodigosPersistence();
        DadosDeCodigos codigos = persistence.get();
        codigo = codigos.getCodigoCliente();
        codigos.setCodigoCliente(codigo + 1);
        persistence.save(codigos);
    }

    public double getCreditosNaLoja() {
        return creditosNaLoja;
    }

    public void setCreditosNaLoja(double creditosNaLoja) {
        this.creditosNaLoja = creditosNaLoja;
    }

    @Override
    public String toString() {
        return this.nome;
    }
}


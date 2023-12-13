package aula.lojaoculos.model;

import aula.lojaoculos.persistence.DadosDeCodigosPersistence;

public abstract class Oculos {
    protected String modelo;
    protected String marca;
    protected double preco;
    protected int codigo;

    public Oculos(String modelo, String marca, double preco) {
        this.modelo = modelo;
        this.marca = marca;
        this.preco = preco;
        DadosDeCodigosPersistence persistence = new DadosDeCodigosPersistence();
        DadosDeCodigos codigos = persistence.get();
        codigo = codigos.getCodigoOculos();
        codigos.setCodigoOculos(codigo + 1);
        persistence.save(codigos);
    }
}

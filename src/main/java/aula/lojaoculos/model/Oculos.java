package aula.lojaoculos.model;

import aula.lojaoculos.persistence.DadosDeCodigosPersistence;

public abstract class Oculos {

    protected String modelo;
    protected String marca;
    protected double preco;
    protected int codigo;

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

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

    @Override
    public String toString() {
        return this.modelo + " - " + this.marca;
    }
}

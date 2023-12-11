package aula.lojaoculos.model;

public abstract class Oculos {
    protected String modelo;
    protected String marca;
    protected double preco;

    public Oculos(String modelo, String marca, double preco) {
        this.modelo = modelo;
        this.marca = marca;
        this.preco = preco;
    }
}

package aula.lojaoculos.model;

public abstract class Desconto {
    protected String codigo;
    protected int numeroDeUsos;

    public Desconto(String codigo, int numeroDeUsos) {
        this.codigo = codigo;
        this.numeroDeUsos = 0;
    }
    public abstract double calculaDesconto(double valor);
}

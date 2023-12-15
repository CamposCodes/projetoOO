package aula.lojaoculos.model;

public abstract class Desconto {

    protected String codigo;

    protected int numeroDeUsos;

    public int getNumeroDeUsos() {
        return numeroDeUsos;
    }

    public void setNumeroDeUsos(int numeroDeUsos) {
        this.numeroDeUsos = numeroDeUsos;
    }

    public Desconto(String codigo) {
        this.codigo = codigo;
        numeroDeUsos = 0;
    }
    public abstract double calculaDesconto(double valor);
}

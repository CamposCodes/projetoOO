package aula.lojaoculos.model;

public abstract class Cashback extends Desconto{
    float porcentagem;

    public Cashback(String codigo, int numeroDeUsos, float porcentagem) {
        super(codigo, numeroDeUsos);
        this.porcentagem = porcentagem;
    }

    @Override
    public double calculaDesconto(double valor) {
        return valor*porcentagem/100.0;
    }
}

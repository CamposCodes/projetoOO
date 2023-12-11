package aula.lojaoculos.model;

public  class Cashback extends Desconto{
    double porcentagem;

    public Cashback(String codigo, double porcentagem) {
        super(codigo);
        this.porcentagem = porcentagem;
    }

    @Override
    public double calculaDesconto(double valor) {
        return valor*porcentagem/100.0;
    }
}

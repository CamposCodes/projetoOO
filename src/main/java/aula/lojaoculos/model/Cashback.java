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

    public double getPorcentagem() {
        return porcentagem;
    }

    public void setPorcentagem(double porcentagem) {
        this.porcentagem = porcentagem;
    }

    @Override
    public String getTipo() {
        return "Cashback";
    }

    @Override
    public String toString() {
        return this.codigo + " - Cashback";
    }
}

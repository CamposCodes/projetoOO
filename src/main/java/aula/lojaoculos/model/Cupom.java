package aula.lojaoculos.model;

public class Cupom extends Desconto {
    private double valorDoCupom;
    private double valorMinimoUso;


    public Cupom(String codigo, double valorDoCupom, int valorMinimoUso) {
        super(codigo);
        this.valorDoCupom = valorDoCupom;
        this.valorMinimoUso = valorMinimoUso;
    }
    @Override
    public double calculaDesconto(double valor) {

        if(valor < valorMinimoUso){
            throw new RuntimeException(); //TODO: DESENVOLVER EXCEÇÃO PARA LANÇAR AQUI
        }

        return valor - valorDoCupom;
    }
}

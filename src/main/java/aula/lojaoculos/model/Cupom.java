package aula.lojaoculos.model;

public class Cupom extends Desconto {
    private int valorDoCupom;

    public Cupom(String codigo, int numeroDeUsos, int valorDoCupom, int valorMinimoUso) {
        super(codigo, numeroDeUsos);
        this.valorDoCupom = valorDoCupom;
    }
    @Override
    public double calculaDesconto(double valor) {
        if ((valor > 300.0) && (valor <=500.0)){
            this.valorDoCupom = 50;
            return valorDoCupom;
        }
        else if ((valor > 500.0) && (valor < 1000.0)){
            this.valorDoCupom = 100;
            return valorDoCupom;
        }
        else if (valor > 1000.0){
            this.valorDoCupom = 150;
            return valorDoCupom;
        }
        else{
            return 0;
        }

    }
}

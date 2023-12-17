/*Integrantes:
   - Gabriel Campos (202176005)
   - Álvaro Thees (202165003A)
*/
package aula.lojaoculos.model;

import aula.lojaoculos.exceptions.ValorMinimoException;

public class Cupom extends Desconto {
    private double valorDoCupom;
    private double valorMinimoUso;


    public Cupom(String codigo, double valorDoCupom, double valorMinimoUso) {
        super(codigo);
        this.valorDoCupom = valorDoCupom;
        this.valorMinimoUso = valorMinimoUso;
    }

    public double getValorDoCupom() {
        return valorDoCupom;
    }

    public void setValorDoCupom(double valorDoCupom) {
        this.valorDoCupom = valorDoCupom;
    }

    public double getValorMinimoUso() {
        return valorMinimoUso;
    }

    public void setValorMinimoUso(double valorMinimoUso) {
        this.valorMinimoUso = valorMinimoUso;
    }

    @Override
    public double calculaDesconto(double valor) throws ValorMinimoException {

        if(valor < valorMinimoUso){
            throw new ValorMinimoException("O valor mínimo para usar esse cupom é R$" + valorMinimoUso);
        }

        return valor - valorDoCupom;
    }

    @Override
    public String getTipo() {
        return "Cupom";
    }

    @Override
    public String toString() {
        return this.codigo + " - Cupom";
    }
}

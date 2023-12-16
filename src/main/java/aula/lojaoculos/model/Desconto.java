package aula.lojaoculos.model;

public abstract class Desconto {

    protected String codigo;


    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Desconto(String codigo) {
        this.codigo = codigo;
    }
    public abstract double calculaDesconto(double valor);
}

package aula.lojaoculos.model;

public class DadosDeCodigos {

    private static int codigoCliente;

    private static int codigoFuncionario;

    private static int codigoOculos;

    public DadosDeCodigos() {
        codigoCliente = 0;
        codigoFuncionario = 0;
        codigoOculos = 0;
    }

    public int getCodigoCliente() {
        return codigoCliente;
    }

    public void setCodigoCliente(int codigoCliente) {
        codigoCliente = codigoCliente;
    }

    public int getCodigoFuncionario() {
        return codigoFuncionario;
    }

    public void setCodigoFuncionario(int codigoFuncionario) {
        codigoFuncionario = codigoFuncionario;
    }

    public int getCodigoOculos() {
        return codigoOculos;
    }

    public void setCodigoOculos(int codigoOculos) {
        this.codigoOculos = codigoOculos;
    }
}

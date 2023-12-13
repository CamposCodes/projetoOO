package aula.lojaoculos.model;

public class DadosDeCodigos {

    private int codigoCliente;

    private int codigoFuncionario;

    private int codigoOculos;

    private int codigoVenda;

    public DadosDeCodigos() {
        this.codigoCliente = 0;
        this.codigoFuncionario = 0;
        this.codigoOculos = 0;
        this.codigoVenda = 0;
    }

    public int getCodigoCliente() {
        return codigoCliente;
    }

    public void setCodigoCliente(int codigoCliente) { this.codigoCliente = codigoCliente; }

    public int getCodigoFuncionario() {
        return codigoFuncionario;
    }

    public void setCodigoFuncionario(int codigoFuncionario) {
        this.codigoFuncionario = codigoFuncionario;
    }

    public int getCodigoOculos() {
        return codigoOculos;
    }

    public int getCodigoVenda() {
        return codigoVenda;
    }

    public void setCodigoVenda(int codigoVenda) {
        this.codigoVenda = codigoVenda;
    }

    public void setCodigoOculos(int codigoOculos) {
        this.codigoOculos = codigoOculos;
    }
}

package aula.lojaoculos.model;

import aula.lojaoculos.persistence.DadosDeCodigosPersistence;

import java.lang.String;
import java.util.List;


public class Venda {
    private double valor;
    private List<Item> itens;
    private Funcionario vendedor;
    private Cliente cliente;
    private String codigoDesconto;

    public List<Item> getItens() {
        return itens;
    }

    public void setItens(List<Item> itens) {
        this.itens = itens;
    }

    public Funcionario getVendedor() {
        return vendedor;
    }

    public void setVendedor(Funcionario vendedor) {
        this.vendedor = vendedor;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public void setCodigoDesconto(String codigoDesconto) {
        this.codigoDesconto = codigoDesconto;
    }

    public double getCreditosCliente() {
        return creditosCliente;
    }

    public void setCreditosCliente(double creditosCliente) {
        this.creditosCliente = creditosCliente;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    private double creditosCliente;
    private int codigo;

    public Venda(double valor, Funcionario vendedor, Cliente cliente, String codigoDesconto, double creditosCliente, int codigo) {
        this.valor = valor;
        this.codigo = codigo;
        this.vendedor = vendedor;
        this.cliente = cliente;
        this.codigoDesconto = codigoDesconto;
        this.creditosCliente = creditosCliente;
        DadosDeCodigosPersistence persistence = new DadosDeCodigosPersistence();
        DadosDeCodigos codigos = persistence.get();
        codigo = codigos.getCodigoFuncionario();
        codigos.setCodigoFuncionario(codigo + 1);
        persistence.save(codigos);
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
    public int getIdentificador() {
        return codigo;
    }

    public void setIdentificador(int identificador) {
        this.codigo = identificador;
    }

    public String getCodigoDesconto() {
        return codigoDesconto;
    }

    public void setCodigodesconto(String codigoDesconto) {
        this.codigoDesconto = codigoDesconto;
    }

    public double isCreditosCliente() {
        return creditosCliente;
    }

    public void setCreditoscliente(double creditosCliente) {
        this.creditosCliente = creditosCliente;
    }
}

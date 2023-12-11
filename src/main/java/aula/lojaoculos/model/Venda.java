package aula.lojaoculos.model;

import java.util.Date;
import java.lang.String;


public class Venda {
    private double valor;
    private Date dataTransacao;
    private int nPrestracoes;
    private int identificador;
    private int vendedor;
    private int cliente;
    private String codigoDesconto;
    private double valorDesconto;
    private double creditosCliente;

    public Venda(double valor, Date dataTransacao, int nPrestracoes, int identificador, int vendedor, int cliente, String codigoDesconto, double valorDesconto, double credtiosCliente) {
        this.valor = valor;
        this.dataTransacao = dataTransacao;
        this.nPrestracoes = nPrestracoes;
        this.identificador = identificador;
        this.vendedor = vendedor;
        this.cliente = cliente;
        this.codigoDesconto = codigoDesconto;
        this.valorDesconto = valorDesconto;
        this.creditosCliente = credtiosCliente;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public Date getDataTransacao() {
        return dataTransacao;
    }

    public void setDatatransacao(Date dataTransacao) {
        this.dataTransacao = dataTransacao;
    }

    public int getNprestracoes() {
        return nPrestracoes;
    }

    public void setNprestracoes(int nPrestracoes) {
        this.nPrestracoes = nPrestracoes;
    }

    public int getIdentificador() {
        return identificador;
    }

    public void setIdentificador(int identificador) {
        this.identificador = identificador;
    }

    public int getVendedor() {
        return vendedor;
    }

    public void setVendedor(int vendedor) {
        this.vendedor = vendedor;
    }

    public int getCliente() {
        return cliente;
    }

    public void setCliente(int cliente) {
        this.cliente = cliente;
    }

    public String getCodigoDesconto() {
        return codigoDesconto;
    }

    public void setCodigodesconto(String codigoDesconto) {
        this.codigoDesconto = codigoDesconto;
    }

    public double getValorDesconto() {
        return valorDesconto;
    }

    public void setValorDesconto(double valorDesconto) {
        this.valorDesconto = valorDesconto;
    }

    public double isCreditosCliente() {
        return creditosCliente;
    }

    public void setCreditoscliente(double creditosCliente) {
        this.creditosCliente = creditosCliente;
    }
}

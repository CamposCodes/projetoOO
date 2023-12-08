package aula.lojaoculos;

import java.time.LocalDate;

public class Chefe {
    private CalculadoraVendas calculadoraVendas;

    public Chefe() {
        calculadoraVendas = new CalculadoraVendas();  
    }

    // Método para consultar o total de vendas em um determinado dia
    public double consultarVendasPorDia(LocalDate dia) {
        return calculadoraVendas.getTotalVendasPorDia(dia);
    }

    
    // Método para acessar a calculadora de vendas e registrar uma venda
    public void registrarVenda(double valorVenda) {
        calculadoraVendas.registrarVenda(valorVenda);
    }
     
    public CalculadoraVendas getCalculadoraVendas() {
        return calculadoraVendas;
    }
}
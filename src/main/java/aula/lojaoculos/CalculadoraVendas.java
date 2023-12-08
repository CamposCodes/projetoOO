package aula.lojaoculos;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class CalculadoraVendas {
    private Map<LocalDate, Double> vendasPorDia;

    public CalculadoraVendas() {
        vendasPorDia = new HashMap<>();
    }

    // Método para registrar uma venda em um determinado dia
    public void registrarVenda(double valorVenda) {
        LocalDate hoje = LocalDate.now();
        vendasPorDia.put(hoje, vendasPorDia.getOrDefault(hoje, 0.0) + valorVenda);
    }

    // Método para obter o total de vendas em um determinado dia
    public double getTotalVendasPorDia(LocalDate dia) {
        return vendasPorDia.getOrDefault(dia, 0.0);
    }
}

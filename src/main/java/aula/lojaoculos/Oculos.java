package aula.lojaoculos;

public abstract class Oculos {
    private String marca;
    private double preco;
    private String tipo;
    private boolean polarizado;

    public Oculos(String marca, String tipo, boolean polarizado) {
        this.marca = marca;
        this.tipo = tipo;
        this.polarizado = polarizado;
        // Definir o preço baseado no tipo/modelo e se é polarizado ou não
        this.preco = calcularPreco();
    }

    public final double calcularPreco() {
        double precoBase = getPrecoBase();

        if (isPolarizado()) {
            precoBase += 50.0; // Adiciona um adicional se for polarizado
        }

        return precoBase;
    }

    // Método abstrato para obter o preço base do óculos
    public abstract double getPrecoBase();

    // Getters e Setters para os atributos (marcados como abstratos se necessário)

    public boolean isPolarizado() {
        return polarizado;
    }

    public void setPolarizado(boolean polarizado) {
        this.polarizado = polarizado;
        // Recalcula o preço quando a polarização é alterada
        this.preco = calcularPreco();
    }

    String getTipo() {
        throw new UnsupportedOperationException("Not supported yet."); 
    }
}
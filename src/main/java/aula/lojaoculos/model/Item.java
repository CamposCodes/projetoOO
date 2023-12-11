package aula.lojaoculos.model;

public class Item {
    double custoUnitario;
    int quantidade;
    double total;

    public Item(double custoUnitario, int quantidade, double total) {
        this.custoUnitario = custoUnitario;
        this.quantidade = quantidade;
        this.total = total;
    }

    public double getCustoUnitario() {
        return custoUnitario;
    }

    public void setCustoUnitario(double custoUnitario) {
        this.custoUnitario = custoUnitario;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
}

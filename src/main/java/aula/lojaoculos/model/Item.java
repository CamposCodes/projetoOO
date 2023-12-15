package aula.lojaoculos.model;

public class Item {
    double custoUnitario;
    int quantidade;
    double total;
    Oculos produto;

    public Oculos getProduto() {
        return produto;
    }

    @Override
    public String toString() {
        return produto.getModelo();
    }

    public Item(double custoUnitario, int quantidade, double total, Oculos produto) {
        this.custoUnitario = custoUnitario;
        this.quantidade = quantidade;
        this.total = total;
        this.produto = produto;
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

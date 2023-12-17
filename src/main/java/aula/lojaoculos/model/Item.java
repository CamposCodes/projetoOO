/*Integrantes:
   - Gabriel Campos (202176005)
   - Álvaro Thees (202165003A)
*/
package aula.lojaoculos.model;

public class Item {
    private double custoUnitario;
    private int quantidade;
    private double total;
    private Oculos produto;

    public Oculos getProduto() {
        return produto;
    }

    public Item(double custoUnitario, int quantidade, double total, Oculos produto) {
        this.custoUnitario = custoUnitario;
        this.quantidade = quantidade;
        this.total = total;
        this.produto = produto;
    }

    @Override
    public String toString() {
        return produto.getMarca() + " / " + produto.getModelo() + " - Preço: R$" + produto.getPreco() + " - Qtd: " + quantidade + " = R$" + total;
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

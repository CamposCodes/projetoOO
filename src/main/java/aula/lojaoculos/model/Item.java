package aula.lojaoculos.model;

public class Item {
    double custoUnitario;
    int quatidade;
    double total;

    public Item(double custoUnitario, int quatidade, double total) {
        this.custoUnitario = custoUnitario;
        this.quatidade = quatidade;
        this.total = total;
    }

    public double getCustoUnitario() {
        return custoUnitario;
    }

    public void setCustoUnitario(double custoUnitario) {
        this.custoUnitario = custoUnitario;
    }

    public int getQuatidade() {
        return quatidade;
    }

    public void setQuatidade(int quatidade) {
        this.quatidade = quatidade;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
}

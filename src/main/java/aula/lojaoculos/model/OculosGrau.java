package aula.lojaoculos.model;

public class OculosGrau extends Oculos {
    private double grauEsquerda;
    private double grauDireita;
    private String tipoLente;

    public OculosGrau(String modelo, String marca, double preco, double grauEsquerda, double grauDireita, String tipoLente) {
        super(modelo, marca, preco);
        this.grauEsquerda = grauEsquerda;
        this.grauDireita = grauDireita;
        this.tipoLente = tipoLente;
    }

    public String getTipo(){
        return "G";
    }
    public double getGrauEsquerda() {
        return grauEsquerda;
    }

    public void setGrauEsquerda(double grauEsquerda) {
        this.grauEsquerda = grauEsquerda;
    }

    public double getGrauDireita() {
        return grauDireita;
    }

    public void setGrauDireita(double grauDireita) {
        this.grauDireita = grauDireita;
    }

    public String getTipoLente() {
        return tipoLente;
    }

    public void setTipoLente(String tipoLente) {
        this.tipoLente = tipoLente;
    }
}

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

}

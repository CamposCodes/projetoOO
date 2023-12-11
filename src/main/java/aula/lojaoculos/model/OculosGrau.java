package aula.lojaoculos.model;

public class OculosGrau extends Oculos {
    private float grauEsquerda;
    private float grauDireita;
    private String tipoLente;

    public OculosGrau(String modelo, String marca, double preco, float grauEsquerda, float grauDireita, String tipoLente) {
        super(modelo, marca, preco);
        this.grauEsquerda = grauEsquerda;
        this.grauDireita = grauDireita;
        this.tipoLente = tipoLente;
    }

}

package aula.lojaoculos.model;

public class OculosGrauEscuro extends OculosGrau{
    private String polarizado;
    String corDaLente;

    public OculosGrauEscuro(String modelo, String marca, double preco, double grauEsquerda, double grauDireita, String tipoLente, String polarizado, String corDaLente) {
        super(modelo, marca, preco, grauEsquerda, grauDireita, tipoLente);
        this.polarizado = polarizado;
        this.corDaLente = corDaLente;
    }
}

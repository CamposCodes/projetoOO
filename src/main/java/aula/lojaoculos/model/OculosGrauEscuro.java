package aula.lojaoculos.model;

public class OculosGrauEscuro extends OculosGrau{
    private boolean polarizado;
    String corDaLente;

    public OculosGrauEscuro(String modelo, String marca, double preco, double grauEsquerda, double grauDireita, String tipoLente, boolean polarizado, String corDaLente) {
        super(modelo, marca, preco, grauEsquerda, grauDireita, tipoLente);
        this.polarizado = polarizado;
        this.corDaLente = corDaLente;
    }
}

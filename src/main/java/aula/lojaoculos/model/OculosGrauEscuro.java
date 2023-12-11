package aula.lojaoculos.model;

public class OculosGrauEscuro extends OculosEscuros{
    private boolean polarizado;
    String corDaLente;

    public OculosGrauEscuro(String modelo, String marca, double preco, boolean polarizado, String corDaLente) {
        super(modelo, marca, preco, polarizado, corDaLente);
        this.polarizado = polarizado;
        this.corDaLente = corDaLente;
    }
}

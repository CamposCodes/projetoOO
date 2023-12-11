package aula.lojaoculos.model;

public class OculosEscuros extends Oculos{
    private boolean polarizado;
    private String corDaLente;

    public OculosEscuros(String modelo, String marca, double preco, boolean polarizado, String corDaLente) {
        super(modelo, marca, preco);
        this.polarizado = polarizado;
        this.corDaLente = corDaLente;
    }

}

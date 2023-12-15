package aula.lojaoculos.model;

public class OculosEscuros extends Oculos{
    private String polarizado;
    private String corDaLente;

    public OculosEscuros(String modelo, String marca, double preco, String polarizado, String corDaLente) {
        super(modelo, marca, preco);
        this.polarizado = polarizado;
        this.corDaLente = corDaLente;
    }

}

package aula.lojaoculos.model;

public class OculosEscuros extends Oculos{
    private String polarizado;
    private String corDaLente;

    public String getPolarizado() {
        return polarizado;
    }

    public String getTipo(){
        return "E";
    }

    public void setPolarizado(String polarizado) {
        this.polarizado = polarizado;
    }

    public String getCorDaLente() {
        return corDaLente;
    }

    public void setCorDaLente(String corDaLente) {
        this.corDaLente = corDaLente;
    }

    public OculosEscuros(String modelo, String marca, double preco, String polarizado, String corDaLente) {
        super(modelo, marca, preco);
        this.polarizado = polarizado;
        this.corDaLente = corDaLente;
    }

}

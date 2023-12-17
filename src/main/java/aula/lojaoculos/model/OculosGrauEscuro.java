/*Integrantes:
   - Gabriel Campos (202176005)
   - Álvaro Thees (202165003A)
*/
package aula.lojaoculos.model;

public class OculosGrauEscuro extends OculosGrau{
    private String polarizado;
    String corDaLente;

    public String getPolarizado() {
        return polarizado;
    }

    public void setPolarizado(String polarizado) {
        this.polarizado = polarizado;
    }

    public String getCorDaLente() {
        return corDaLente;
    }

    public String getTipo(){
        return "GE";
    }

    public void setCorDaLente(String corDaLente) {
        this.corDaLente = corDaLente;
    }

    public OculosGrauEscuro(String modelo, String marca, double preco, double grauEsquerda, double grauDireita, String tipoLente, String polarizado, String corDaLente) {
        super(modelo, marca, preco, grauEsquerda, grauDireita, tipoLente);
        this.polarizado = polarizado;
        this.corDaLente = corDaLente;
    }
}

package aula.lojaoculos.model;

public class OculosRedondo extends Oculos {

    public OculosRedondo(String marca, String tipo, boolean polarizado) {
        super(marca, tipo, polarizado);
    }

    public String getTipo() {
        return "OculosRedondo";
    }
    
    public double getPrecoBase() {
        return 200.0; // Preço base para o Modelo Esportivo
    }
}
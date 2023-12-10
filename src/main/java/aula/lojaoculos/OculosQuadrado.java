package aula.lojaoculos;

public class OculosQuadrado extends Oculos {

    public OculosQuadrado(String marca, String tipo, boolean polarizado) {
        super(marca, tipo, polarizado);
    }

    public String getTipo() {
        return "OculosQuadrado";
    }
        
    public double getPrecoBase() {
        return 150.0; // Preço base para o Modelo Esportivo
    }
}
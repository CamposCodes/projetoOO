package aula.lojaoculos;

public class OculosEsportivo extends Oculos {
    private String tipoMaterial;

    public OculosEsportivo(String marca, String tipo, boolean polarizado, String tipoMaterial) {
        super(marca, tipo, polarizado);
        this.tipoMaterial = tipoMaterial;
    }

    public String getTipo() {
        return "OculosEsportivo";
    }

    public String getTipoMaterial() {
        return tipoMaterial;
    }

    public void setTipoMaterial(String tipoMaterial) {
        this.tipoMaterial = tipoMaterial;
    }
    

    public double getPrecoBase() {
        return 100.0; // Preço base para o Modelo Esportivo
    }
}
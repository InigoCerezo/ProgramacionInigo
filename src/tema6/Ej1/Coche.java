package tema6.Ej1;

public class Coche extends Vehiculo{
    private int plazas;
    private String tipoUso;
    public Coche(String marca, String modelo, String matricula, int plazas, String tipoUso) {
        super(marca, modelo, matricula);
        this.plazas = plazas;
        this.tipoUso = tipoUso;
    }

    public int getPlazas() {
        return plazas;
    }

    public String getTipoUso() {
        return tipoUso;
    }
}

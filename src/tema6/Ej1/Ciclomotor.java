package tema6.Ej1;

public class Ciclomotor extends Vehiculo {
    private int cilindrada;

    public Ciclomotor(String marca, String modelo, String matricula, int cilindrada) {
        super(marca, modelo, matricula);
        this.cilindrada = cilindrada;
    }

    public int getCilindrada() { return cilindrada; }

    public boolean necesitaCarnet() {
        return this.cilindrada >= 125;
    }
}
package tema6.Ej1;

public class Camion extends Vehiculo {
    private double maxWeightKg; // En kg o toneladas
    private boolean mercanciaPeligrosa;

    public Camion(String marca, String modelo, String matricula, double pesoMaximoAutorizado, boolean mercanciaPeligrosa) {
        super(marca, modelo, matricula);
        this.maxWeightKg = pesoMaximoAutorizado;
        this.mercanciaPeligrosa = mercanciaPeligrosa;
    }

    public double getMaxWeightKg() { return maxWeightKg; }
    public boolean isMercanciaPeligrosa() { return mercanciaPeligrosa; }
}
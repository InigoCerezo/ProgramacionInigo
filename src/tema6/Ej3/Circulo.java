package tema6.Ej3;

public class Circulo extends Fig2D {
    private double radio;
    public Circulo(double radio) {
        this.radio = radio;
    }

    @Override
    public double area() {
        // Fórmula: π * r²
        return Math.PI * Math.pow(radio, 2);
    }

    @Override
    public double perimetro() {
        // Fórmula: 2 * π * r
        return 2 * Math.PI * radio;
    }

    @Override
    public String toString() {
        return "Círculo (radio: " + radio + ") -> Área: " + String.format("%.2f", area()) + " | Perímetro: " + String.format("%.2f", perimetro());
    }
}

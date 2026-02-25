package tema6.Ej3;

public class Triangulo extends Fig2D {
    private double lado1;
    private double lado2;
    private double lado3;

    public Triangulo(double lado1, double lado2, double lado3) {
        this.lado1 = lado1;
        this.lado2 = lado2;
        this.lado3 = lado3;
    }

    @Override
    public double perimetro() {
        return lado1 + lado2 + lado3;
    }

    @Override
    public double area() {
        // Usamos la fórmula de Herón
        double s = perimetro() / 2;
        return Math.sqrt(s * (s - lado1) * (s - lado2) * (s - lado3));
    }

    @Override
    public String toString() {
        return "Triángulo (lados: " + lado1 + ", " + lado2 + ", " + lado3 + ") -> Área: " + String.format("%.2f", area()) + " | Perímetro: " + perimetro();
    }
}

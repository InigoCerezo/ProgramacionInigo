package tema6.Ej3;

public class Rectangulo extends Fig2D {
    // Usamos protected para que la clase hija (Cuadrado) pueda acceder a ellos si lo necesita
    protected double base;
    protected double altura;

    public Rectangulo(double base, double altura) {
        this.base = base;
        this.altura = altura;
    }

    @Override
    public double area() {
        return base * altura;
    }

    @Override
    public double perimetro() {
        return 2 * (base + altura);
    }

    @Override
    public String toString() {
        return "Rectángulo (base: " + base + ", altura: " + altura + ") -> Área: " + area() + " | Perímetro: " + perimetro();
    }
}

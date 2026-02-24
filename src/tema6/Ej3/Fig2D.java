package tema6.Ej3;

public abstract class Fig2D {
    public abstract double area();
    public abstract double perimetro();

    @Override
    public String toString() {
        return "Figura 2D [Área: " + String.format("%.2f", area()) +
                ", Perímetro: " + String.format("%.2f", perimetro()) + "]";
    }
}

package tema6.Ej3;

public class Cuadrado extends Rectangulo {

    public Cuadrado(double lado) {
        //esto lo hace más facil ya que si hereda rectangulo lo tiene to.do
        super(lado, lado);
    }
    //menos el toString pero eso se arregla
    @Override
    public String toString() {
        return "Cuadrado (lado: " + base + ") -> Área: " + area() + " | Perímetro: " + perimetro();
    }
}

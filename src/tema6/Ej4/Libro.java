package tema6.Ej4;

public class Libro extends Ficha {
    private String autor;
    private String editorial;

    public Libro(int numero, String titulo, String autor, String editorial) {
        super(numero, titulo);
        this.autor = autor;
        this.editorial = editorial;
    }

    @Override
    public void mostrarDetalles() {
        System.out.println("📖 LIBRO [#" + numero + "] - " + titulo);
        System.out.println("   Autor: " + autor + " | Editorial: " + editorial);
        System.out.println("   Estado: " + (prestado ? "Prestado" : "Disponible"));
    }
}

package tema6.Ej4;

public class Revista extends Ficha {
    private int numeroPublicacion;
    private int ano;

    public Revista(int numero, String titulo, int numeroPublicacion, int ano) {
        super(numero, titulo);
        this.numeroPublicacion = numeroPublicacion;
        this.ano = ano;
    }

    @Override
    public void mostrarDetalles() {
        System.out.println("📰 REVISTA [#" + numero + "] - " + titulo);
        System.out.println("   Año: " + ano + " | Nº de publicación: " + numeroPublicacion);
        System.out.println("   Estado: " + (prestado ? "Prestado" : "Disponible"));
    }
}

package tema6.Ej4;

enum TipoDVD {
    ANIMACION, ACCION, DOCUMENTAL, CIENCIA_FICCION, COMEDIA, DRAMA
}
public class DVD extends Ficha {
    private String director;
    private int ano;
    private TipoDVD tipo;

    public DVD(int numero, String titulo, String director, int ano, TipoDVD tipo) {
        super(numero, titulo);
        this.director = director;
        this.ano = ano;
        this.tipo = tipo;
    }

    @Override
    public void mostrarDetalles() {
        System.out.println("DVD [ "+ numero + "] - " + titulo);
        System.out.println("Director: " + director + " | Año: " + ano + " | Género: " + tipo);
        System.out.println("Estado: " + (prestado ? "Prestado" : "Disponible"));
    }
}

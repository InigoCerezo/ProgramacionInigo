package tema6.Ej4;

public abstract class Ficha {
    protected int numero;
    protected String titulo;
    protected boolean prestado;
    public Ficha(int numero, String titulo) {
        this.numero = numero;
        this.titulo = titulo;
        this.prestado = false;}

    public void prestar() {
        if (!prestado) {
            prestado = true;
            System.out.println("Se ha prestado con éxito: " + titulo);
        } else {
            System.out.println("Lo sentimos, '" + titulo + "' ya está prestado.");
        }
    }

    public void devolver() {
        if (prestado) {
            prestado = false;
            System.out.println("Se ha devuelto: " + titulo);
        } else {
            System.out.println("'" + titulo + "' ya estaba en la biblioteca, no se puede devolver.");
        }
    }

    public abstract void mostrarDetalles();

    public int getNumero() { return numero; }
    public String getTitulo() { return titulo; }
    public boolean isPrestado() { return prestado; }
}


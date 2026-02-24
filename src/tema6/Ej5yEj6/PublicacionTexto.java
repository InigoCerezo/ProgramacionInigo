package tema6.Ej5yEj6;

public class PublicacionTexto implements Reaccion {
    private String autor;
    private String contenido;

    public PublicacionTexto(String autor, String contenido) {
        this.autor = autor;
        this.contenido = contenido;
    }

    @Override
    public void publicar() {
        System.out.println(autor + " ha publicado un nuevo estado: '" + contenido + "'");
    }

    @Override
    public void compartir() {
        System.out.println("Compartiendo el estado de " + autor + "...");
    }

    @Override
    public void comentar(String textoCom) {
        System.out.println("Comentario en el texto de " + autor + ": " + textoCom);
    }
}

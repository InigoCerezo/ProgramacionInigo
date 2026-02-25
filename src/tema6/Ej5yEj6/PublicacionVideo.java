package tema6.Ej5yEj6;

public class PublicacionVideo implements Reaccion, AbrirPublicacion {
    private String autor;
    private int duracionSegundos;

    public PublicacionVideo(String autor, int duracionSegundos) {
        this.autor = autor;
        this.duracionSegundos = duracionSegundos;
    }

    @Override
    public void publicar() {
        System.out.println(autor + " está procesando y publicando un vídeo de " + duracionSegundos + " segundos.");
    }

    @Override
    public void compartir() {
        System.out.println("Enviando el vídeo de " + autor + " por mensaje directo.");
    }

    @Override
    public void abrir() {
        System.out.println("Reproduciendo el vídeo...");
    }
    @Override
    public void comentar(String texto) {
        System.out.println("Comentario en el vídeo de " + autor + ": " + texto);
    }
}

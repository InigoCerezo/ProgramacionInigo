package tema6.Ej5yEj6;

public class PublicacionFoto implements Reaccion, AbrirPublicacion {
    private String autor;
    private String urlImagen;
    private String filtro;

    public PublicacionFoto(String autor, String urlImagen, String filtro) {
        this.autor = autor;
        this.urlImagen = urlImagen;
        this.filtro = filtro;
    }

    @Override
    public void publicar() {
        System.out.println(autor + " ha subido una foto con el filtro '" + filtro + "'.");
    }

    @Override
    public void compartir() {
        System.out.println("Compartiendo la foto de " + autor + " mediante un enlace directo.");
    }

    @Override
    public void abrir() {
        System.out.println("Abriendo la foto desde: " + urlImagen);
    }
    @Override
    public void comentar(String texto) {
        System.out.println("Comentario en la foto de " + autor + ": " + texto);
    }
}

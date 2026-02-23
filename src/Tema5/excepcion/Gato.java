package Tema5.excepcion;

public class Gato {
    private String nombre;
    private int edad;
    public Gato() {
        this.nombre = "whiscas";
        this.edad = 44;
    }
    public Gato(String nombre, int edad) {
        setNombre(nombre);
        setEdad(edad);
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        if (nombre.length() >= 3) {
            this.nombre = nombre;
        } else{
            throw new IllegalArgumentException("\nEl nombre debe tener 3 letras.");
        }
    }
    public int getEdad() {
        return edad;
    }
    public void setEdad(int edad) {
        if (edad >= 0) {
            this.edad = edad;
        } else {
            throw new IllegalArgumentException("\nLa edad debe ser positiva.");
        }
    }
    @Override
    public String toString() {
        return "Gato{" + "nombre=" + nombre + ", edad=" + edad + '}';
    }
}

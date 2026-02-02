package Tema4.POO2;

public class Persona {
    private String nombre;
    private final String dni;

    public Persona(){
        this.dni = null;
        this.nombre = "pepe";
    }

    public Persona(String nombre, String dni){
        this.nombre = nombre;
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getDni() {
        return dni;
    }
}

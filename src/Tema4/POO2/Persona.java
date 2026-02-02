package Tema4.POO2;

public class Persona{
    private String nombre;
    private final String dni;
    private Cuenta[] cuenta;

    public Persona(){
        this.dni = null;
        this.nombre = "pepe";
        this.cuenta = new Cuenta[3];
    }

    public Persona(String nombre, String dni){
        this.nombre = nombre;
        this.dni = dni;
        this.cuenta = new Cuenta[3];
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
    public Cuenta[] getCuenta() {
        return cuenta;
    }
    public void setCuenta(int i, Cuenta[] cuenta) {
        this.cuenta[i] = cuenta[i];
    }
}

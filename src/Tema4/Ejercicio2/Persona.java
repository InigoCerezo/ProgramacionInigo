package Tema4.Ejercicio2;

public class Persona {
    public static final int edadDef = 30;
    public String nombre, apellidos;
    private String dni;
    private int edad;
    public Persona (String nombre, String apellidos, String dni, int edad){
        if(edad<=0 || edad > 100){
            this.edad = edadDef;
        }else{
            setEdad(edad);
        }
        setNombre(nombre);
        setApellidos(apellidos);
    }
    public void validDni(String dni){
        if (dni.length() == 9)
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getApellidos() {
        return apellidos;
    }
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }
    public int getEdad() {
        return edad;
    }
    public void setEdad(int edad) {
        this.edad = edad;
    }
    public String getDni() {
        return dni;
    }
    public void setDni(String dni) {
        this.dni = dni;
    }
}

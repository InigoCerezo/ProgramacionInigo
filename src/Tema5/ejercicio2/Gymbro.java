package Tema5.ejercicio2;

public class Gymbro {
    public String nombre;
    private int edad;
    private String dni;

    public Gymbro(){
        this.nombre = "Usuario";
        this.edad = 0;
        this.dni = "123456789";
    }

    public Gymbro(String nombre, int edad, String dni) {
        setNombre(nombre);
        setEdad(edad);
        setDni(dni);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        if(edad < 0 || edad > 100){
            this.edad = 0;
        }else{
            this.edad = edad;
        }
    }
    public String getDni() {
        return dni;
    }
    public void setDni(String dni) {
        if(dni.isEmpty()){
            System.out.println("El dni del usuario no puede estar vacio");
        }else{
            this.dni = dni;
        }
    }

    public String toString(){
        return String.format("%s, con DNI %s, tiene %d años.",nombre,dni,edad);
    }
}

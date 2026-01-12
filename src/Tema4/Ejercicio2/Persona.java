package Tema4.Ejercicio2;

public class Persona {
    public static final int adultAge = 18;
    public static final int retiredAge = 65;
    public String nombre, apellidos;
    private String dni;
    private int edad;
    public Persona (String nombre, String apellidos, String dni, int edad){
        if(edad<=0 || edad > 100){
            this.edad = 0;
        }else{
            setEdad(edad);
        }
        setNombre(nombre);
        setApellidos(apellidos);
        if (validDni(dni)) {
            setDni(dni);
        }else{
            setDni("99999999A (dni invalido)");
        }
    }
    public String print(){
        if(this.dni.length() == 9){
            return String.format("%s %s, con DNI %s con %d años.",nombre,apellidos,dni,edad);
        }else{
            return String.format("%s %s, sin DNI VALIDO con %d años.",nombre,apellidos,edad);
        }
    }

    public boolean isAdult(){
        return edad >= adultAge;
    }
    public boolean isRetired(){
        return edad >= retiredAge;
    }
    public void ageDiff(Persona uno, Persona dos){
        if (uno.edad > dos.edad){
            System.out.printf("\n%s es mas mayor que %s.",uno.getNombre(),dos.getNombre());

        }else if(uno.edad < dos.edad){
            System.out.printf("\n%s es mas mayor que %s.",dos.getNombre(),uno.getNombre());

        }else{
            System.out.printf("\n%s y %s tienen la misma edad.",uno.getNombre(),dos.getNombre());

        }
    }
    public boolean validDni(String dni){
        if (dni.length() != 9 || !Character.isLetter(dni.charAt(8))){
            return false;
        }
        String mayus = (dni.substring(8)).toUpperCase();
        return numeros(dni) && letraDni(dni).equals(mayus);
    }
    public boolean numeros(String dni) {
        String numero, miDni = "";
        String[] unoNueve = {"0","1","2","3","4","5","6","7","8","9"};
        for(int i = 0; i < (dni.length()) - 1; i++){
            numero = dni.substring(i, i+1);
            for(int j = 0; j < unoNueve.length; j++){
                if (numero.equals(unoNueve[j])){
                    miDni += unoNueve[j];
                }
            }
        }
        return miDni.length() == 8;
    }
    public String letraDni(String dni){
        int miDni = Integer.parseInt(dni.substring(0,8));
        int resto = 0;
        String letra = "";
        String[] asignacion = {"T","R","W","A","G","M","Y","F","P","D","X","B","N","J","Z","S","Q","V","H","L","C","K","E"};
        resto = miDni % 23;
        letra = asignacion[resto];
        return letra;
    }

    public String getNombre() {
        return nombre;
    }
    public String getApellidos() {
        return apellidos;
    }
    public int getEdad() {
        return edad;
    }
    public String getDni() {
        return dni;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }
    public void setEdad(int edad) {
        this.edad = edad;
    }
    public void setDni(String dni) {
        this.dni = dni;
    }
}

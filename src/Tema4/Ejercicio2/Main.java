package Tema4.Ejercicio2;

public class Main {
    public static void main(String[] args){
        Persona persona = new Persona("Manuel", "Garcia","20494811V",44);
        Persona persono = new Persona("Samuel","Rodriguez","54324442T",55);
        System.out.println(persona);
        System.out.println(persona.getNombre());
        System.out.println(persona.getApellidos());
        System.out.println(persona.getEdad());
        System.out.println(persona.getDni());
        System.out.println(persona.print());
        System.out.println(persona.isAdult());
        System.out.println(persona.isRetired());
        persona.ageDiff(persona, persono);
    }
}

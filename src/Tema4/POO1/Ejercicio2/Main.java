package Tema4.POO1.Ejercicio2;

public class Main {
    public static void main(String[] args){
        Persona persona = new Persona("Manuel", "Garcia","20494811V",13);
        Persona persono = new Persona("Samuel","Rodriguez","54324442T",44);
        System.out.println(persona);
        System.out.println(persona.getNombre());
        System.out.println(persona.getApellidos());
        System.out.println(persona.getEdad());
        System.out.println(persona.getDni());
        System.out.println(persona.print());
        if(!persona.isAdult()){
            System.out.println(persona.getNombre() + " no es mayor de edad.");
        }else{
            System.out.println(persona.getNombre() + " es mayor de edad.");
        }
        if(!persona.isRetired()){
            System.out.println(persona.getNombre() + " no esta jubilado/a.");
        }else {
            System.out.println(persona.getNombre() + " esta jubilado/a.");
        }
        persona.ageDiff(persona, persono);
    }
}

package Tema5.coleccion.ejercicio2;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Gimnasio {
    static Scanner sc = new Scanner(System.in);

    public static void nuUser(String nombre, String dni, int edad, Map<String, Gymbro> usuarios) {
        if (usuarios.containsKey(dni)) {
            System.out.println("Usuario con mismo DNI ya registrado.");
        }else{
            usuarios.put(dni, new Gymbro(nombre,edad,dni));
            System.out.println("Tu usuario ha sido registrado.");
        }
    }
    public static void baja(String dni, Map<String, Gymbro> usuarios){
        if (usuarios.containsKey(dni)) {
            usuarios.remove(dni);
            System.out.println("Tu usuario ha sido borrado.");
        }else{
            System.out.println("Usuario no encontrado.");
        }
    }
    public static void modded(String dni, Map<String, Gymbro> usuarios){
        if (usuarios.containsKey(dni)) {
            usuarios.put(dni,changeGymbro(dni));
            System.out.println("Se le han cambiado los datos a tu usuario.");
        }else {
            System.out.println("Usuario no encontrado.");
        }
    }
    public static String print(String dni, Map<String, Gymbro> usuarios){
        Gymbro g = usuarios.get(dni);
        return g.toString();
    }
    public static void main(String[] args) {
        Map<String, Gymbro> usuarios;
        usuarios = new HashMap<>();
        boolean loop = true;
        char lost;
        String nom, dni;
        int edad;
        System.out.println("Bienvenido al gimnasio.");
        while (loop) {
            menuGym();
            lost = sc.next().charAt(0);
            switch (lost) {
                case 'a':
                    System.out.println("Introduce un nombre");
                    nom = sc.next();
                    System.out.println("Introduce una edad");
                    edad = sc.nextInt();
                    System.out.println("Introduce tu DNI");
                    dni = sc.next();
                    nuUser(nom, dni, edad,usuarios);
                    break;
                case 'b':
                    System.out.println("Introduce tu DNI");
                    dni = sc.next();
                    baja(dni, usuarios);
                    break;
                case 'c':
                    System.out.println("Introduce tu DNI");
                    dni = sc.next();
                    modded(dni, usuarios);
                    break;
                case 'd':
                    System.out.println("Introduce tu DNI");
                    dni = sc.next();
                    System.out.println(print(dni, usuarios));
                    break;
                case 'x':
                    loop = false;
                    break;
                default:
                    System.out.println("Opcion no valida.");
                    break;
            }
        }
    }
    public static Gymbro changeGymbro(String dni) {
        System.out.println("Nombre:");
        String nombre = sc.next();
        System.out.println("Edad:");
        int edad = sc.nextInt();
        return new Gymbro(nombre,edad,dni);
    }
    public static void menuGym(){
        System.out.println("-------------------------------");
        System.out.println("a. Crear un nuevo usuario");
        System.out.println("b. Dar de baja un usuario");
        System.out.println("c. Modificar usuario");
        System.out.println("d. Ver datos de un usuario");
        System.out.println("x. Salir");
    }
}

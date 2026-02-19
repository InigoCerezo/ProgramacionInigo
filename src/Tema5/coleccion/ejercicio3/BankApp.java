package Tema5.coleccion.ejercicio3;

import java.util.Scanner;

public class BankApp {
    static Scanner sc = new Scanner(System.in);
    public static void clear(){
        for (int i = 0;i<20;i++){
            System.out.println();
        }
    }
    public static void menu() {
        clear();
        System.out.println("\n=== MENÚ BANCO ===");
        System.out.println("a. Añadir persona a la cola");
        System.out.println("b. Atender al primero de la cola");
        System.out.println("c. Alguien abandona la cola (por DNI)");
        System.out.println("d. Mostrar el estado de la cola");
        System.out.println("x. Salir del programa");
    }
    public static void main(String[] args) {
        Banker banker = new Banker();
        char opcion;
        banker.anadirACola("Ana García", 34, "12345678A");
        banker.anadirACola("Carlos López", 45, "87654321B");
        banker.anadirACola("Beatriz Martínez", 29, "11223344C");
        banker.anadirACola("David Fernández", 60, "55667788D");
        do {
            menu();
            sc.nextLine();
            opcion = sc.next().charAt(0);
            opcion = Character.toUpperCase(opcion);switch (opcion) {
                case 'A':
                    System.out.print("Introduce el nombre: ");
                    String nombre = sc.nextLine();
                    System.out.print("Introduce la edad: ");
                    int edad = sc.nextInt();
                    sc.nextLine();//por si hay buffer
                    System.out.print("Introduce el DNI: ");
                    String dni = sc.nextLine();
                    banker.anadirACola(nombre, edad, dni);
                    break;
                case 'B':
                    banker.atenderPrimero();
                    break;
                case 'C':
                    System.out.print("Introduce el DNI de la persona que se va: ");
                    String dniBuscar = sc.nextLine();
                    banker.abandonarCola(dniBuscar);
                    break;
                case 'D':
                    banker.mostrarEstado();
                    break;
                case 'X':
                    System.out.println("Cerrando el sistema.");
                    break;
                default:
                    System.out.println(" pción no válida. Por favor, elige un número del 1 al 5.");
            }
        } while (opcion != 5);
    }
}

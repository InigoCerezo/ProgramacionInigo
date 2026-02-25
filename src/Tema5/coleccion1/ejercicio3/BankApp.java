package Tema5.coleccion1.ejercicio3;

import java.util.Scanner;

import static java.lang.Thread.sleep;

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
    public static void main(String[] args) throws InterruptedException {

        Banker banker = new Banker();
        char opcion;
        banker.anadirACola("Ulayclon", 3324, "12345678A");
        banker.anadirACola("Space monkey", 435, "090909090332");
        banker.anadirACola("toji", 29, "8");
        banker.anadirACola("kkhjhjk", 60, "yea");
        do {
            menu();
            opcion = sc.next().charAt(0);
            sc.nextLine();
            opcion = Character.toUpperCase(opcion);
            switch (opcion) {
                case 'A':
                    System.out.print("Introduce el nombre: ");
                    String nombre = sc.nextLine();
                    System.out.print("Introduce la edad: ");
                    int edad = sc.nextInt();
                    sc.nextLine();//por si hay buffer
                    System.out.print("Introduce el DNI: ");
                    String dni = sc.nextLine();
                    banker.anadirACola(nombre, edad, dni);
                    sleep(1000);
                    break;
                case 'B':
                    banker.atenderPrimero();
                    sleep(1000);
                    break;
                case 'C':
                    System.out.print("Introduce el DNI de la persona que se va: ");
                    String dniBuscar = sc.nextLine();
                    banker.abandonarCola(dniBuscar);
                    sleep(1000);
                    break;
                case 'D':
                    banker.mostrarEstado();
                    sleep(1000);
                    break;
                case 'X':
                    System.out.println("Cerrando el sistema.");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcion != 'X');
    }
}

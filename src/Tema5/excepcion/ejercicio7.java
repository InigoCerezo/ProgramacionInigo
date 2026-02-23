package Tema5.excepcion;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import static java.lang.Thread.sleep;

public class ejercicio7 {
    static Scanner sc = new Scanner(System.in);
    static final int MAX_GATOS = 5;
    public static void menu() {
        clear();
        System.out.println("\n=== MENÚ GATO ===");
        System.out.println("a. Añadir gato (Max 5)");
        System.out.println("b. Mostrar gatos");
        System.out.println("x. Salir del programa");
    }
    public static void main(String[] args) throws InterruptedException {
        ArrayList<Gato> catlist = new ArrayList<>();
        boolean b = true;
        char opcion;
        try {
            do {
                menu();
                opcion = sc.next().charAt(0);
                opcion = Character.toUpperCase(opcion);
                sc.nextLine();
                switch (opcion) {
                    case 'A':
                        if (catlist.size() < MAX_GATOS) {
                            System.out.println("Ingresa el nombre del gato");
                            String name = sc.nextLine();
                            System.out.println("Ingresa la edad del gato");
                            int edad = sc.nextInt();
                            Gato gato = new Gato(name, edad);
                            catlist.add(gato);
                            System.out.println("Gato añadido");
                            sleep(1000);
                        } else {
                            System.out.println("Ya tienes el límite de gatos.");
                        }
                        break;
                    case 'B':
                        if (catlist.isEmpty()) {
                            System.out.println("La cola está totalmente vacía.");
                        } else {
                            for (int i = 0; i < catlist.size(); i++) {
                                System.out.println((i + 1) + ". " + catlist.get(i).toString());
                            }
                        }
                        break;
                    case 'X':
                        System.out.println("Saliendo");
                        b = false;
                        break;
                    default:
                        System.out.println("WELL THIS STINKS");
                        break;
                }
            } while (b);
        }
        catch (IllegalArgumentException e) {
            System.err.println("Error: "+e.getMessage());
        }
        catch (InputMismatchException e) {
            System.err.println("Error: Se ha introducido un carácter no debido.");
        }
        catch (Exception e) {
            System.out.println("Algo ha pasado, y el programa te ha dado error. "+e.getMessage());
        }
    }
    public static void clear(){
        for (int i = 0;i<10;i++){
            System.out.println();
        }
    }
}

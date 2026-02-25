package Tema5.coleccion1;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Ejercicio1 {
    static Scanner sc = new Scanner(System.in);
    public static void menu() {
        System.out.println("Carro de compra");//menu global
        System.out.println("--------------------------------------");
        System.out.println("a - Añadir un artículo a la lista");
        System.out.println("b - Añadir un artículo al carrito de compra");
        System.out.println("c - Ver lista y carrito de compra");
        System.out.println("x - Salir");
    }
    public static void main(String[] args) {
        boolean menu = true;
        char chos;

        Set<String> lista = new HashSet<>();
        Set<String> carro = new HashSet<>();
        while (menu) {
            menu();
            chos = sc.next().charAt(0);
            chos = Character.toLowerCase(chos);
            switch(chos){
                case 'a':
                    addThing(lista);
                    break;
                case 'b':
                    addThing(carro);
                    break;
                case 'c':
                    System.out.println("Lista:");
                    seeThing(lista);
                    System.out.println("Carro:");
                    seeThing(carro);
                    break;
                case 'x':
                    menu = false;
                    break;
                default:
                    System.out.println("Opcion incorrecta");
            }
        }
    }
    public static void addThing(Set<String> thing){
        System.out.println("¿Que quieres añadir a la lista?");
        String ojbeto;
        sc.nextLine();
        do {
            ojbeto = sc.nextLine();
            if(!ojbeto.equals("no")){
                if (thing.contains(ojbeto)) {
                    System.out.println("Ya existe un objeto con el mismo nombre.");
                } else {
                    thing.add(ojbeto);
                }
                System.out.println("¿Algo mas? (para salir pon 'no')");
            }
        }while(!ojbeto.equals("no"));
    }
    public static void seeThing(Set<String> thing){
        for(String s : thing){
            System.out.println(s);
        }
    }
}

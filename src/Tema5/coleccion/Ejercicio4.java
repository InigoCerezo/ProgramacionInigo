package Tema5.coleccion;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import static java.lang.Thread.sleep;

public class Ejercicio4 {
    static Scanner sc = new Scanner(System.in);
    public static void menu() {
        System.out.println("Menu compra");//menu global
        System.out.println("--------------------------------------");
        System.out.println("a - Añadir un artículo a la lista");
        System.out.println("b - Añadir un artículo al carrito de compra");
        System.out.println("c - Ver lista y carrito de compra");
        System.out.println("d - Ver artículos pendientes de añadir al carrito");
        System.out.println("x - Salir");
    }
    public static void main(String[] args) throws InterruptedException {
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
                    clear();
                    break;
                case 'b':
                    addThing(carro);
                    clear();
                    break;
                case 'c':
                    System.out.println("Lista:");
                    seeThing(lista);
                    sleep(1000);
                    System.out.println("Carro:");
                    seeThing(carro);
                    clear();
                    break;
                case 'd':
                    seeMissingThing(lista, carro);
                    clear();
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
    public static void seeThing(Set<String> thing) throws InterruptedException {
        for(String s : thing){
            sleep(200);
            System.out.println(s);
        }
    }
    public static void seeMissingThing(Set<String> lista, Set<String> carro) throws InterruptedException {
        Set<String> lista2 = new HashSet<>(lista);
        lista2.removeAll(carro);
        System.out.println("Falta por comprar:");
        for(String s : lista2){
            System.out.println(s);
            sleep(200);
        }
    }
    public static void clear(){
        for (int i = 0;i<20;i++){
            System.out.println();
        }
    }
}

package Tema5;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Ejercicio1 {
    public static void menu() {
        System.out.println("Carro de compra");//menu global
        System.out.println("--------------------------------------");
        System.out.println("a - Añadir un artículo");
        System.out.println("b - Ver carrito de compra");
        System.out.println("c - Salir");
    }
    public static void main(String[] args) {
        boolean menu = true;
        char chos;
        String ojbeto;
        Scanner sc = new Scanner(System.in);
        Set<String> lista = new HashSet<>();
        while (menu) {
            menu();
            chos = sc.next().charAt(0);
            chos = Character.toLowerCase(chos);
            switch(chos){
                case 'a':
                    System.out.println("¿Que quieres añadir a tu carro?");
                    ojbeto = sc.nextLine();
                    ojbeto = sc.nextLine();
                    if(lista.contains(ojbeto)){
                        System.out.println("Ya existe un objeto con el mismo nombre.");
                    }else {
                        lista.add(ojbeto);
                    }
                    break;
                case 'b':
                    for(String s : lista){
                        System.out.println(s);
                    }
                    break;
                case 'c':
                    menu=false;
                    break;
                default:
                    System.out.println("Opcion incorrecta");
            }
        }
    }
}

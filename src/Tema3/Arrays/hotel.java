package Tema3.Arrays;

import java.util.Arrays;
import java.util.Scanner;

public class hotel {
    public static void printArray(int[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + ", ");
        }
        System.out.println();
    }
    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
    public static void main(String[] args){
        //variable inicializacion
        Scanner sc = new Scanner(System.in);
        int[] hotel = new int[20];
        int wifi, hap;
        //amo esta funcion por cierto
        Arrays.fill(hotel, 0);
        System.out.println("Tienes un router, el cual lo tienes que poner en una habitación en un hotel.");
        System.out.println("¿Que habitación eliges? (1 a 20)");
        hap = sc.nextInt();
        while(hap < 1 || hap > 20){
            System.out.println("Elige una habitación correcta, por favor. (1 a 20)");
            hap =  sc.nextInt();
        }
        System.out.println("El router tiene una potencia ajustable.");
        System.out.println("¿Que potencia eliges? (1 a 6)");
        wifi = sc.nextInt();
        while(wifi < 1 || wifi > 6){
            System.out.println("Elige una potencia correcta, por favor. (1 a 6)");
            wifi =  sc.nextInt();
        }
        hotel[hap-1] = wifi;
        for (int i = 0; i < hotel.length; i++){
            // Calculamos la distancia absoluta (pasos) entre la habitación actual (i) y el router
            int distancia = Math.abs((hap-1) - i);

            // La señal es la potencia original menos la distancia
            int senalResultante = wifi - distancia;

            // Si la señal es negativa (está muy lejos), se queda en 0
            if (senalResultante < 0) {
                hotel[i] = 0;
            } else {
                hotel[i] = senalResultante;
            }
        }
        printArray(hotel);
        clearScreen();
    }
}

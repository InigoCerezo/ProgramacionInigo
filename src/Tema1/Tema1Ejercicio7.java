package ProgramaciónAna;

import java.util.Scanner;

public class Tema1Ejercicio7 {
    public static void main(String[] args){
        System.out.println("Tira el dado.");
        Scanner Gam = new Scanner(System.in);
        int ble = Gam.nextInt();
        if((ble > 6) || (ble < 1)) {
            System.out.println("Aw dangit!");
        } else {
            int core = 7 - ble;
            System.out.println("El lado opuesto: " + core);
        }
    }
}

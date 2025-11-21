package Tema2.Bucles;

import java.util.Scanner;

public class T2e22 {
    public static void main(String[] args) {
        System.out.println("Introduce un número");
        Scanner a = new Scanner(System.in);
        int num1 = a.nextInt();
        int divis = 1;
        while (num1 > 10) {
            num1 = num1/10;
            divis++;
        }
        if (divis <= 1){
            System.out.println("Tu número tiene "+divis+" cifra.");
        }else {
            System.out.println("Tu número tiene "+divis+" cifras.");
        }
    }
}

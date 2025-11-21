package Tema3.ModularParte2;

import java.util.Scanner;

public class T3E10myMath {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        for(int i=0;i<a.length();i++) {
            int par = Integer.parseInt(a.charAt(a.length()-1-i) + "");
            if (par % 2 == 1) {
                System.out.print(par);
            }
        }
    }
}

package Tema3.ModularParte2;

import java.util.Scanner;

public class T3E10myMath {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        int par;
        for(int i=0;i<a.length();i++) {
            par = Integer.parseInt(a.charAt(a.length()-1-i) + "");
            if (par % 2 == 0) {
                System.out.println(par);
            }
        }
    }
}

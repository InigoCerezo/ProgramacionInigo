package Tema1;

public class Tema1Ejercicio5{
    public static void main(String[] args) {
        int primer = 24 % 5;
        System.out.println("El resultado es: " + primer);
        double segon = (double) 7/2 + 2.5;
        System.out.println("El resultado es: " + segon);
        double tercer = 10.8/2+2;
        System.out.println("El resultado es: " + tercer);
        int cuarto = (4+6)*3 + 2*(5-1);
        System.out.println("El resultado es: " + cuarto);
        double quinto = (double)5/2 + 17%3;
        System.out.println("El resultado es: " + quinto);
        boolean sexto = 7 >= 5 || 27 != 8;
        System.out.println("El resultado es: " + sexto);
        boolean sept = (45<=7) || !(5>=7);
        System.out.println("El resultado es: " + sept);
        double oct = (double) 27%4 + 15/4;
        System.out.println("El resultado es: " + oct);
        double nov = (double) 37/4*4-2;
        System.out.println("El resultado es: " + nov);
        boolean dec = (25 >= 7) && ! (7<=2);
        System.out.println("El resultado es: " + dec);
        boolean onc = ('H' < 'J') && ('9' != '7');
        System.out.println("El resultado es: " + onc);
        boolean doceno = 25 > 20 && 13 > 5;
        System.out.println("El resultado es: " + doceno);
        boolean treceno = 10 + 4 < 15 - 3 || 2 * 5 + 1 > 14 - 2 * 2;
        System.out.println("El resultado es: " + treceno);
        boolean catorce = 4 * 2 <= 8 || 2 * 2 < 5 && 4 > 3 + 1;
        System.out.println("El resultado es: " + catorce);
        boolean quince = 10 <= 2 * 5 && 3 < 4 || ! (8>7) && 3 * 2 <= 4 * 2 - 1;
        System.out.println("El resultado es: " + quince);

    }
}
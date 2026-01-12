package Tema4.Ejercicio1;

public class RelojMain {
    public static void main(String[] args){
        Reloj reloj = new Reloj(3,54,45);
        reloj.getS();
        reloj.getM();
        reloj.getH();
        System.out.println(reloj);
        reloj.toString();
        System.out.println(reloj);
    }
}

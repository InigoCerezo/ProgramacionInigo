package Tema4.Ejercicio1;

public class RelojMain {
    public static void main(String[] args){
        Reloj reloj = new Reloj(3,54,45);
        System.out.println(reloj.getS());
        System.out.println(reloj.getM());
        System.out.println(reloj.getH());
        System.out.println(reloj);
        reloj.toString();
        System.out.println(reloj);
    }
}

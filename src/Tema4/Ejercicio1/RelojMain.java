package Tema4.Ejercicio1;

public class RelojMain {
    public static void main(String[] args){
        Reloj reloj = new Reloj(3,54,45);
        Reloj reloj1 =  new Reloj();
        reloj.getS();
        reloj.getM();
        reloj.getH();
        System.out.println(reloj);
        reloj1.getS();
        reloj1.getM();
        reloj1.getH();
        System.out.println(reloj1);
        reloj.toString();
        reloj1.toString();
    }
}

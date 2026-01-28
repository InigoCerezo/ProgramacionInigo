package Tema4.POO1.Ejercicio1;

public class RelojMain {
    public static void main(String[] args){
        Reloj reloj = new Reloj(12,54,45);
        Reloj reloj1 =  new Reloj();
        System.out.println(reloj.getS());
        System.out.println(reloj.getM());
        System.out.println(reloj.getH());
        System.out.println(reloj);
        reloj.setMilitTime(false);
        System.out.println(reloj);
        System.out.println(reloj1.getS());
        System.out.println(reloj1.getM());
        System.out.println(reloj1.getH());
        System.out.println(reloj1);
        reloj1.setMilitTime(false);
        reloj1.setH(88);
        System.out.println(reloj1);
    }
}

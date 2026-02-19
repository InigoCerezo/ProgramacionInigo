package Tema5.excepcion;

public class ejercicio6 {
    public static void main(String[] args) throws Exception{
        Gato miaumiau = new Gato();
        Gato miww = new Gato();
        miaumiau.setNombre("Mimi");
        miaumiau.setEdad(34);
        System.out.println(miww);
        System.out.println(miaumiau);
        Gato miaumiau2 = new Gato("steven",-32);
        System.out.println(miaumiau2);
    }
}

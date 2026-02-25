package tema6.Ej2;

public class Pajaro extends Animal {
    @Override
    public void dormir() {
        System.out.println("El pájaro duerme de pie apoyado en una rama.");
    }

    @Override
    public void hacerRuido() {
        System.out.println("¡Pío! ¡Pío! (Canta una melodía)");
    }

    public void volar() {
        System.out.println("El pájaro agita sus alas y alza el vuelo.");
    }
}

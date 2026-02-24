package tema6.Ej2;

public class Mono extends Animal {
    @Override
    public void comer() {
        System.out.println("El mono está pelando y comiendo una banana.");
    }

    @Override
    public void hacerRuido() {
        System.out.println("¡Uh uh! ¡Ah ah!");
    }

    public void treparArbol() {
        System.out.println("El mono se balancea y trepa rápidamente a la copa del árbol.");
    }
}

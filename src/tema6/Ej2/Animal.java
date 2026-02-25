package tema6.Ej2;

public abstract class Animal {
    public void dormir() {
        System.out.println("El animal se ha dormido.");
    }

    public void comer() {
        System.out.println("El animal está comiendo.");
    }

    public abstract void hacerRuido();
}
package tema6.Ej7yEj8;

public class Fireball implements AdvancedAtk {
    private int costeMana;
    private int danoMagico;

    public Fireball(int costeMana, int danoMagico) {
        this.costeMana = costeMana;
        this.danoMagico = danoMagico;
    }

    @Override
    public void lanzar() {
        System.out.println("¡Lanzando una Bola de Fuego!");
    }

    @Override
    public int[] coste() {
        //solo devuelve coste de mana
        return new int[] { 0, costeMana };
    }

    @Override
    public int[] danoInfligido() {
        //solo inflige daño mágico
        return new int[] { 0, danoMagico };
    }
}

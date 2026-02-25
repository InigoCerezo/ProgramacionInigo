package tema6.Ej7yEj8;

public class Fireball implements AdvancedAtk {
    private int manaReq;
    private int magic;

    public Fireball(int manaReq, int magic) {
        this.manaReq = manaReq;
        this.magic = magic;
    }

    @Override
    public void lanzar() {
        System.out.println("¡Lanzando una Bola de Fuego!");
    }

    @Override
    public int[] coste() {
        //solo devuelve coste de mana
        return new int[] { 0, manaReq };
    }

    @Override
    public int[] danoInfligido() {
        //solo inflige daño mágico
        return new int[] { 0, magic };
    }
}

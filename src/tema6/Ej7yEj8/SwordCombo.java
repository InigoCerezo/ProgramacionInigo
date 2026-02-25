package tema6.Ej7yEj8;

public class SwordCombo implements AdvancedAtk {
    private int nrgReq;
    private int physical;

    public SwordCombo(int nrgReq, int physical) {
        this.nrgReq = nrgReq;
        this.physical = physical;
    }

    @Override
    public void lanzar() {
        System.out.println("¡Dando un poderoso tajo con la espada!");
    }

    @Override
    public int[] coste() {
        //solo devuelve coste de esfuerzo
        return new int[] { nrgReq, 0 };
    }

    @Override
    public int[] danoInfligido() {
        //solo inflige daño físico
        return new int[] { physical, 0 };
    }
}

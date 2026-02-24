package tema6.Ej7yEj8;

public class SwordCombo implements AdvancedAtk {
    private int costeEsfuerzo;
    private int danoFisico;

    public SwordCombo(int costeEsfuerzo, int danoFisico) {
        this.costeEsfuerzo = costeEsfuerzo;
        this.danoFisico = danoFisico;
    }

    @Override
    public void lanzar() {
        System.out.println("⚔️ ¡Dando un poderoso tajo con la espada!");
    }

    @Override
    public int[] coste() {
        //solo devuelve coste de esfuerzo
        return new int[] { costeEsfuerzo, 0 };
    }

    @Override
    public int[] danoInfligido() {
        //solo inflige daño físico
        return new int[] { danoFisico, 0 };
    }
}

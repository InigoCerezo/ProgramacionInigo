package tema6.Ej7yEj8;

public class MagicSwordAttack implements AdvancedAtk {
    private int costeEsfuerzo;
    private int costeMana;
    private int danoFisico;
    private int danoMagico;

    public MagicSwordAttack(int costeEsfuerzo, int costeMana, int danoFisico, int danoMagico) {
        this.costeEsfuerzo = costeEsfuerzo;
        this.costeMana = costeMana;
        this.danoFisico = danoFisico;
        this.danoMagico = danoMagico;
    }

    @Override
    public void lanzar() {
        System.out.println("¡Golpeando con la espada envuelta en pura energía mágica!");
    }

    @Override
    public int[] coste() {
        //devuelve ambos costes
        return new int[] { costeEsfuerzo, costeMana };
    }

    @Override
    public int[] danoInfligido() {
        //devuelve ambos tipos de daño
        return new int[] { danoFisico, danoMagico };
    }
    /*
    no se si lo que quiero yo hacer es posible con este
    luego lo averiguo
     */
}

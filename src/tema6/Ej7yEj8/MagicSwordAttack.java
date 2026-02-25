package tema6.Ej7yEj8;

public class MagicSwordAttack implements AdvancedAtk {
    private int nrgReq;
    private int manaReq;
    private int physical;
    private int magic;

    public MagicSwordAttack(int nrgReq, int manaReq, int physical, int magic) {
        this.nrgReq = nrgReq;
        this.manaReq = manaReq;
        this.physical = physical;
        this.magic = magic;
    }

    @Override
    public void lanzar() {
        System.out.println("¡Golpeando con la espada envuelta en pura energía mágica!");
    }

    @Override
    public int[] coste() {
        //devuelve ambos costes
        return new int[] { nrgReq, manaReq };
    }

    @Override
    public int[] danoInfligido() {
        //devuelve ambos tipos de daño
        return new int[] { physical, magic };
    }
    /*
    no se si lo que quiero yo hacer es posible con este
    luego lo averiguo
     */
}

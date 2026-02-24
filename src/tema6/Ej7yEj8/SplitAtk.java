package tema6.Ej7yEj8;

public class SplitAtk implements Atk {
    private String nombre;
    private int nrgReq;
    private int manaReq;
    private int physical;
    private int magic;

    public SplitAtk(String nombre, int nrgReq, int manaReq, int physical, int magic) {
        this.nombre = nombre;
        this.nrgReq = nrgReq;
        this.manaReq = manaReq;
        this.physical = physical;
        this.magic = magic;
    }

    @Override
    public void lanzar() {
        System.out.println("Desatando ataque híbrido: ¡" + nombre + "!");
    }

    @Override
    public int coste() {
    //el coste total podría ser la suma de ambos recursos gastados
        return nrgReq + manaReq;
    }
    /* hay varios que me gustan personalmente
    @Override
    public int coste() {
    //dividido entre dos
        return (nrgReq + manaReq)/2;
    }
    @Override
    public int coste() {
    //poniendo más energia que mana
        return (nrgReq * 2) + manaReq;
    }
    @Override
    public int coste() {
    //poniendo mas mana que energia
        return nrgReq + (manaReq * 2);
    }
    hay más pero no me voy a poner a escribirlos
     */

    @Override
    public int danoInfligido() {
        // El daño total es la combinación del impacto físico y la magia
        return physical + magic;
    }
}

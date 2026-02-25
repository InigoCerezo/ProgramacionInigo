package tema6.Ej7yEj8;

public class MagicAtk implements Atk {
    private String nombreHechizo;
    private int manaReq;
    private int magPow;

    public MagicAtk(String nombreHechizo, int manaReq, int magPow) {
        this.nombreHechizo = nombreHechizo;
        this.manaReq = manaReq;
        this.magPow = magPow;
    }

    @Override
    public void lanzar() {
        System.out.println("Conjurando hechizo: ¡" + nombreHechizo + "!");
    }

    @Override
    public int coste() {
        return manaReq;
    }

    @Override
    public int danoInfligido() {
        return magPow;
    }
}

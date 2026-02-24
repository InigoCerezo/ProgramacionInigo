package tema6.Ej7yEj8;

public class PhysAtk implements Atk {
    private String nombre;
    private int nrgReq;
    private int dano;

    public PhysAtk(String nombre, int nrgReq, int dano) {
        this.nombre = nombre;
        this.nrgReq = nrgReq;
        this.dano = dano;
    }

    @Override
    public void lanzar() {
        System.out.println("Lanzando ataque físico: ¡" + nombre + "!");
    }

    @Override
    public int coste() {
        return nrgReq;
    }
    
    @Override
    public int danoInfligido() {
        return dano;
    }
}

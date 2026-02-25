package tema6.Ej2;

public class Gato extends Animal {
    @Override
    public void comer() {
        System.out.println("El gato está comiendo lasaña.");
    }
    @Override
    public void hacerRuido() {
        System.out.println("¡Miau! ¡Miau!");
    }
    public void ronronear() {
        System.out.println("El gato ronronea porque le estás rascando detrás de las orejas.");
    }
}

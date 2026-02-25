package tema6.Ej2;

public class PezGlobo extends Animal {
    @Override
    public void comer() {
        System.out.println("El pez globo va a un arrecife y se zampa unos caracoles.");
    }
    @Override
    public void hacerRuido(){
        System.out.println("Blub blub.");
    }
}
